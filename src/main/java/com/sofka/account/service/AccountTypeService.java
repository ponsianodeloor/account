package com.sofka.account.service;

import com.sofka.account.model.AccountType;
import com.sofka.account.repository.AccountTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountTypeService {

    @Autowired
    private AccountTypeRepository accountTypeRepository;

    public List<AccountType> getAllAccountTypes() {
        return accountTypeRepository.findAll();
    }

    public AccountType getAccountTypeById(String id) {
        return accountTypeRepository.findById(id).orElseThrow(() -> new RuntimeException("Account Type not found"));
    }

    public AccountType addAccountType(AccountType accountType) {
        return accountTypeRepository.save(accountType);
    }

}
