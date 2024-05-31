package com.sofka.account.service;

import com.sofka.account.dto.TransactionUsernameSearchResponse;
import com.sofka.account.model.Account;
import com.sofka.account.model.Transaction;
import com.sofka.account.model.TransactionType;
import com.sofka.account.repository.AccountRepository;
import com.sofka.account.repository.TransactionRepository;
import com.sofka.account.repository.TransactionTypeRepository;
import com.sofka.account.service.utils.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TransactionService {
    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private TransactionTypeRepository transactionTypeRepository;

    @Autowired
    private AccountRepository accountRepository;

    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

    public Transaction getTransactionById(String id) {
        return transactionRepository.findById(id).orElseThrow(() -> new RuntimeException("Transaction not found"));
    }

    /**
     * Agregar transaccion puede ser deposito, retiro o transferencia
     * @param transaction
     * @return
     * @throws RuntimeException
     * @Author: Ponsiano De Loor
     */
    public Transaction addTransaction(Transaction transaction) {
        // Identificar el tipo de transaccion con transaccionType
        TransactionType transactionType = transactionTypeRepository.findById(transaction.getTransactionType().getId()).orElseThrow(
                () -> new RuntimeException("Transaction type not found"));

        // Buscar cuenta bancaria
        Account account = accountRepository.findById(transaction.getAccountId()).orElseThrow(
                () -> new RuntimeException("Account not found"));

        // validar si es deposito, retiro o transferencia
        switch (transactionType.getCode()) {
            case Constant.DEPOSIT_CODE:
                transaction.setBalance(account.getBalance());
                account.setBalance(account.getBalance().add(transaction.getAmount()));
                break;
            case Constant.WITHDRAWAL_CODE:
                // Validar si hay suficiente saldo
                transaction.setBalance(account.getBalance());
                account.setBalance(account.getBalance().subtract(transaction.getAmount().abs()));

                //compare if the balance is less than 0
                if (account.getBalance().compareTo(Constant.ZERO) < 0) {
                    throw new RuntimeException("Insufficient balance");
                }
                break;
            case Constant.EXTERNAL_TRANSFER:
                //external transfer with taxes and commision
                transaction.setBalance(transaction.getAmount());
                break;
            default:
                throw new RuntimeException("Transaction type not valid");
        }

        // Guardar la transaccion
        transaction.setState(true);

        accountRepository.save(account);
        transaction.setNewBalance(account.getBalance());

        return transactionRepository.save(transaction);
    }


    public List<Transaction> getTransactionsByDateRange(Date from, Date to) {
        return transactionRepository.findByDatetimeTransactionBetween(from, to);
    }

    public List<TransactionUsernameSearchResponse> getTransactionsByUsernameDateRange(String username,Date from, Date to) {
        List<Transaction> transactions = transactionRepository.findByDatetimeTransactionBetween(from, to);
        return transactions.stream()
                .map(transaction -> {
                    TransactionUsernameSearchResponse dto = new TransactionUsernameSearchResponse();
                    Account account = accountRepository.findById(transaction.getAccountId()).orElseThrow(
                            () -> new RuntimeException("Account not found"));
                    dto.setFecha(transaction.getDatetimeTransaction());
                    dto.setNumeroCuenta(account.getAccountNumber());
                    dto.setSaldoInicial(transaction.getBalance());
                    dto.setTipo(transaction.getTransactionType().getName());
                    dto.setEstado(transaction.getState());
                    dto.setMovimiento(transaction.getAmount());
                    dto.setSaldoDisponible(transaction.getNewBalance());
                    // Set other properties
                    return dto;
                })
                .collect(Collectors.toList());
    }


}
