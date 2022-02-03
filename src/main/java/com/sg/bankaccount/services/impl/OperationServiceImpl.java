package com.sg.bankaccount.services.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sg.bankaccount.models.Account;
import com.sg.bankaccount.models.EOperation;
import com.sg.bankaccount.models.Operation;
import com.sg.bankaccount.repositories.OperationRepository;
import com.sg.bankaccount.rest.requests.ClientTransaction;
import com.sg.bankaccount.services.OperationService;

@Service
public class OperationServiceImpl implements OperationService{
	
	@Autowired
	private OperationRepository operationRepository;

	@Override
	public List<Operation> displayOperationsByAccount(String accountNumber) {
		
		return operationRepository.findByAccountAccountNumberOrderByOperationDateDesc(accountNumber);
	}

	@Override
	public Operation createAndSaveOperation(Account account, ClientTransaction clientTransaction, EOperation operationName) {

		Operation operation =new Operation();
		operation.setOperationDate(new Date());
		operation.setOperationAmount(clientTransaction.getAmount());
		operation.setDescription(clientTransaction.getDescription());
		operation.setAccount(account);
		operation.setBalanceAfterTransaction(account.getAccountBalance());
		operation.setOperationName(operationName);
		return operationRepository.save(operation);
	}

}
