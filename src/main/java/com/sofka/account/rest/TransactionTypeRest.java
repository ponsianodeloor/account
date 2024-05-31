package com.sofka.account.rest;

import com.sofka.account.model.TransactionType;
import com.sofka.account.service.TransactionTypeService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Transaction Type", description = "API para tipos de transacciones")
@RestController
@RequestMapping("/api/v1.0")
@CrossOrigin(origins = {"*"})
public class TransactionTypeRest {
    @Autowired
    private TransactionTypeService transactionTypeService;

    @GetMapping("/transactionTypes")
    public List<TransactionType> getAllTransactionTypes() {
        return transactionTypeService.getAllTransactionTypes();
    }

    @GetMapping("/transactionType/{id}")
    public TransactionType getTransactionTypeById(String id) {
        return transactionTypeService.getTransactionTypeById(id);
    }

    @PostMapping("/transactionType")
    public TransactionType addTransactionType(@RequestBody TransactionType transactionType) {
        return transactionTypeService.addTransactionType(transactionType);
    }
}
