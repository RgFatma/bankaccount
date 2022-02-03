package com.sg.bankaccount.services;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.sg.bankaccount.models.Account;
import com.sg.bankaccount.models.Client;
import com.sg.bankaccount.models.EAccountType;
import com.sg.bankaccount.models.EOperation;
import com.sg.bankaccount.models.Operation;
import com.sg.bankaccount.repositories.OperationRepository;
import com.sg.bankaccount.rest.requests.ClientTransaction;
import com.sg.bankaccount.services.impl.OperationServiceImpl;

@SpringJUnitConfig(classes = OperationServiceImpl.class)
class OperationServiceImplTest {
	
	@Autowired
	OperationServiceImpl operationServiceImpl;
	
	@MockBean
	private OperationRepository operationRepository;
	
	@Test
	void displayOperationsByAccountTest() {
		Client client = new Client();
		client.setId(1l);
		
		Account account = new Account();
		account.setAccountNumber("00015365845320114");
		account.setAccountBalance(100.0);
		account.setAccountType(EAccountType.COURANT);
		account.setClient(client);
		
		List<Account>accounts=new ArrayList<>();
		accounts.add(account);
		List<Long> accountsId = new ArrayList<>();
		accountsId.add(account.getId());
		
		Operation operation=new Operation();
		operation.setAccount(account);
		operation.setOperationDate(new Date());
		
		List<Operation> operations=new ArrayList<>();
		operations.add(operation);
		
		Mockito.when(operationRepository.findByAccountAccountNumberOrderByOperationDateDesc("00015365845320114")).thenReturn(operations);
		
		List<Operation> returnedList=operationServiceImpl.displayOperationsByAccount("00015365845320114");
		assertEquals(1, returnedList.size());
	}
	
	@Test
	void createAndSaveOperationTest() {
		
		ClientTransaction clientTransaction=new ClientTransaction();
		clientTransaction.setAccountNumber("00215639555634");
		clientTransaction.setAmount(100.00);
		
		Client client = new Client();
		client.setId(1l);
		
		Account account = new Account();
		account.setAccountNumber("00215639555634");
		account.setAccountBalance(1000.0);
		account.setAccountType(EAccountType.COURANT);
		account.setClient(client);
		
		Operation operation= new Operation();
		operation.setOperationAmount(100.00);
		
		Mockito.when(operationRepository.save(Mockito.any(Operation.class))).thenReturn(operation);
		
		Operation returnedOperation=operationServiceImpl.createAndSaveOperation(account, clientTransaction, EOperation.CREDIT);
		assertEquals(100.00,returnedOperation.getOperationAmount());
	}
	

}
