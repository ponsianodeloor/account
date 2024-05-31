package com.sofka.account;

import com.sofka.account.model.Account;
import com.sofka.account.repository.AccountRepository;
import com.sofka.account.service.AccountService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
class AccountApplicationTests {


	@InjectMocks
	AccountService accountService;

	@Mock
	AccountRepository accountRepository;

	@BeforeEach
	public void init() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	public void getAllAccountsTest() {
		Account account1 = new Account();
		Account account2 = new Account();
		when(accountRepository.findAll()).thenReturn(Arrays.asList(account1, account2));

		List<Account> accounts = accountService.getAllAccounts();

		assertEquals(2, accounts.size());
	}

}
