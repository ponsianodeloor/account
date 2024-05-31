package com.sofka.account.rest;

import com.sofka.account.dto.AccountTypeResponse;
import com.sofka.account.model.AccountType;
import com.sofka.account.service.AccountTypeService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Tag(name = "Account Type", description = "API para tipos de cuenta")
@RestController
@RequestMapping("/api/v1.0")
@CrossOrigin(origins = {"*"})
public class AccountTypeRest {

        @Autowired
        private AccountTypeService accountTypeService;

        @GetMapping("/accountTypes")
        public List<AccountTypeResponse> getAllAccountTypes() {
            List<AccountType> accountTypes = accountTypeService.getAllAccountTypes();

            return accountTypes.stream()
                    .map(accountType -> new AccountTypeResponse(
                            accountType.getId(),
                            accountType.getName(),
                            accountType.getCode(),
                            accountType.getDescription(),
                            accountType.getState()))
                    .collect(Collectors.toList());
        }

        @GetMapping("/accountType/{id}")
        public AccountType getAccountTypeById(@PathVariable("id") String id) {
            return accountTypeService.getAccountTypeById(id);
        }

        @PostMapping("/accountType")
        public AccountType addAccountType(@RequestBody AccountType accountType) {
            return accountTypeService.addAccountType(accountType);
        }
}
