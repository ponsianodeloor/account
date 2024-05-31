package com.sofka.account.service;

import com.sofka.account.model.TransactionType;
import com.sofka.account.repository.TransactionTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionTypeService {
    @Autowired
    private TransactionTypeRepository transactionTypeRepository;

    public List<TransactionType> getAllTransactionTypes() {
        return transactionTypeRepository.findAll();
    }

    public TransactionType getTransactionTypeById(String id) {
        return transactionTypeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Transaction Type not found"));
    }

    public TransactionType addTransactionType(TransactionType transactionType) {
        return transactionTypeRepository.save(transactionType);
    }
}
