package com.sofka.account.rest;

import com.sofka.account.dto.TransactionUsernameSearchResponse;
import com.sofka.account.model.Transaction;
import com.sofka.account.service.TransactionService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
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
    public Transaction getTransactionById(@PathVariable("id") String id) {
        return transactionService.getTransactionById(id);
    }

    @PostMapping("/transaction")
    public Transaction addTransaction(@RequestBody Transaction transaction) {
        return transactionService.addTransaction(transaction);
    }

    @GetMapping("/transactions/search")
    public List<Transaction> getTransactionsByDateRange(
            @RequestParam("from") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date from,
            @RequestParam("to") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date to) {
        return transactionService.getTransactionsByDateRange(from, to);
    }

    @GetMapping("/transactions/username/{username}/search")
    public List<TransactionUsernameSearchResponse> getTransactionsByUsernameDateRange(
            @PathVariable("username") String username,
            @RequestParam("from") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date from,
            @RequestParam("to") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date to) {
        return transactionService.getTransactionsByUsernameDateRange(username, from, to);
    }
}
