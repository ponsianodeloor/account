package com.sofka.account.rest;

import com.sofka.account.model.Account;
import com.sofka.account.model.AccountType;
import com.sofka.account.service.AccountService;
import com.sofka.account.service.AccountTypeService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Account", description = "API para gestionar cuentas")
@RestController
@RequestMapping("/api/v1.0")
@CrossOrigin(origins = {"*"})
public class AccountRest {

    @Autowired
    private AccountService accountService;

    @Autowired
    private AccountTypeService accountTypeService;

    @GetMapping("/accounts")
    public List<Account> getAllAccounts() {
        return accountService.getAllAccounts();
    }

    @GetMapping("/account/{id}")
    public Account getAccountById(@PathVariable("id") String id) {
        return accountService.getAccountById(id);
    }

    @PostMapping("/account")
    public Account addAccount(@RequestBody Account account) {
        return accountService.addAccount(account);
    }

    @GetMapping("/account/{id}/type")
    public AccountType getAccountTypeByAccountId(@PathVariable("id") String id) {
        Account account = accountService.getAccountById(id);
        return account.getAccountType();
    }
}
