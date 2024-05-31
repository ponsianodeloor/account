package com.sofka.account.rest;

import com.sofka.account.model.Transaction;
import com.sofka.account.service.TransactionService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Transaction", description = "API para gestionar transacciones")
@RestController
@RequestMapping("/api/v1.0")
@CrossOrigin(origins = {"*"})
public class TransactionRest {
    @Autowired
    private TransactionService transactionService;

    @GetMapping("/transactions")
    public List<Transaction> getAllTransactions() {
        return transactionService.getAllTransactions();
    }

    @GetMapping("/transaction/{id}")
    public Transaction getTransactionById(String id) {
        return transactionService.getTransactionById(id);
    }

    @PostMapping("/transaction")
    public Transaction addTransaction(@RequestBody Transaction transaction) {

        return transactionService.addTransaction(transaction);
    }
}
