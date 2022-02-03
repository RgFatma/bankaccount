package com.sg.bankaccount.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.sg.bankaccount.exceptions.BadRequestException;
import com.sg.bankaccount.exceptions.RessourceNotFoundException;
import com.sg.bankaccount.models.Account;
import com.sg.bankaccount.models.Client;
import com.sg.bankaccount.repositories.AccountRepository;
import com.sg.bankaccount.rest.requests.ClientTransaction;
import com.sg.bankaccount.rest.responses.AccountBalance;
import com.sg.bankaccount.services.impl.AccountServiceImpl;

@SpringJUnitConfig(classes = AccountServiceImpl.class)
class AccountServiceImplTest {

	@Autowired
	AccountServiceImpl accountServiceImpl;

	@MockBean
	private AccountRepository accountRepository;

	@MockBean
	private OperationService operationService;

	Client client;
	Account account;

	@BeforeEach
	void init() {
		client = new Client();
		client.setId(1l);
		account = new Account();
		account.setAccountNumber("0012548503262001");
		account.setAccountBalance(100.0);
		account.setClient(client);
	}

	@Test
	void depositAccountTestOK() {

		ClientTransaction clientTransaction = new ClientTransaction();
		clientTransaction.setAmount(20.0);
		clientTransaction.setAccountNumber("0012548503262001");

		Mockito.when(
				accountRepository.findByAccountNumber(Mockito.anyString()))
				.thenReturn(Optional.of(account));
		AccountBalance clientBalance = accountServiceImpl.depositAccount(clientTransaction);
		assertEquals(120.0, clientBalance.getAmount());
	}
	
	@Test
	void withdrawalFromAccountTestOK() {
		ClientTransaction clientTransaction = new ClientTransaction();
		clientTransaction.setAmount(40.0);
		clientTransaction.setAccountNumber("0012548503262001");

		Mockito.when(
				accountRepository.findByAccountNumber(Mockito.anyString()))
				.thenReturn(Optional.of(account));
		AccountBalance clientBalance = accountServiceImpl.withdrawalFromAccount(clientTransaction);
		assertEquals(60.0, clientBalance.getAmount());
	}
	
	@Test
	void withdrawalFromAccountTestInsufficientAccountBalance() {
		ClientTransaction clientTransaction = new ClientTransaction();
		clientTransaction.setAmount(160.0);
		clientTransaction.setAccountNumber("0012548503262001");

		Mockito.when(
				accountRepository.findByAccountNumber(Mockito.anyString()))
				.thenReturn(Optional.of(account));
		BadRequestException exception=assertThrows(BadRequestException.class,()->accountServiceImpl.withdrawalFromAccount(clientTransaction));
		assertTrue(exception.getMessage().contains("Your account balance is insufficient to complete this transaction."));
	}
	
	@Test
	void withdrawalFromAccountTestAccountnotFound() {

		Mockito.when(
				accountRepository.findByAccountNumber(Mockito.anyString()))
				.thenReturn(Optional.empty());
		RessourceNotFoundException exception=assertThrows(RessourceNotFoundException.class,()->accountServiceImpl.withdrawalFromAccount(new ClientTransaction()));
		assertTrue(exception.getMessage().contains("The requested account does not exist."));
	}
	
	@Test
	void depositAccountTestAccountnotFound() {

		Mockito.when(
				accountRepository.findByAccountNumber(Mockito.anyString()))
				.thenReturn(Optional.empty());
		RessourceNotFoundException exception=assertThrows(RessourceNotFoundException.class,()->accountServiceImpl.depositAccount(new ClientTransaction()));
		assertTrue(exception.getMessage().contains("The requested account does not exist."));
	}

}
