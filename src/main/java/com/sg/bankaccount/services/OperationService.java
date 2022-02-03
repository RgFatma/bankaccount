package com.sg.bankaccount.services;

import java.util.List;

import com.sg.bankaccount.models.Account;
import com.sg.bankaccount.models.EOperation;
import com.sg.bankaccount.models.Operation;
import com.sg.bankaccount.rest.requests.ClientTransaction;

public interface OperationService {

	Operation createAndSaveOperation(Account account, ClientTransaction clientTransaction, EOperation operationName);
	List<Operation> displayOperationsByAccount(String accountNumber);
	
}
