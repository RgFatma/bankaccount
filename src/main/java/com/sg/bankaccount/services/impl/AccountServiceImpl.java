package com.sg.bankaccount.services.impl;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sg.bankaccount.exceptions.BadRequestException;
import com.sg.bankaccount.exceptions.RessourceNotFoundException;
import com.sg.bankaccount.models.Account;
import com.sg.bankaccount.models.EOperation;
import com.sg.bankaccount.repositories.AccountRepository;
import com.sg.bankaccount.rest.requests.ClientTransaction;
import com.sg.bankaccount.rest.responses.AccountBalance;
import com.sg.bankaccount.rest.responses.ApiError;
import com.sg.bankaccount.rest.responses.ErrorResponse;
import com.sg.bankaccount.services.AccountService;
import com.sg.bankaccount.services.OperationService;
import com.sg.bankaccount.utils.LoggerUtils;

@Service
public class AccountServiceImpl implements AccountService { 

	@Autowired
	private AccountRepository accountRepository;

	@Autowired
	private OperationService operationService;

	@Transactional
	@Override
	public AccountBalance depositAccount(ClientTransaction clientTransaction) {  

		Account account = accountRepository.findByAccountNumber(clientTransaction.getAccountNumber())
				.orElseThrow(() -> new RessourceNotFoundException(new ErrorResponse(ApiError.ACCOUNT_NOT_FOUND.getMessage(),
						ApiError.ACCOUNT_NOT_FOUND.getDescription())));

		account.setAccountBalance(account.getAccountBalance() + clientTransaction.getAmount());

		accountRepository.save(account);
		operationService.createAndSaveOperation(account, clientTransaction, EOperation.DEPIT);
		LoggerUtils.logInfo(String.format("The deposit %s has been sucessfully transacted.The new account balance is %s",clientTransaction.getAmount(),account.getAccountBalance()));
		return new AccountBalance(account.getAccountBalance());

	}

	@Transactional
	@Override
	public AccountBalance withdrawalFromAccount(ClientTransaction clientTransaction) {

		Account account = accountRepository.findByAccountNumber(clientTransaction.getAccountNumber())
				.orElseThrow(() -> new RessourceNotFoundException(new ErrorResponse(ApiError.ACCOUNT_NOT_FOUND.getMessage(),
						ApiError.ACCOUNT_NOT_FOUND.getDescription())));

		if (clientTransaction.getAmount() > account.getAccountBalance()) {
			throw new BadRequestException(new ErrorResponse(ApiError.INSUFFICIENT_BALANCE.getMessage(),
					ApiError.INSUFFICIENT_BALANCE.getDescription()));
		}

		account.setAccountBalance(account.getAccountBalance() - clientTransaction.getAmount());

		accountRepository.save(account);
		operationService.createAndSaveOperation(account, clientTransaction, EOperation.CREDIT);
		LoggerUtils.logInfo(String.format("The retreive %s has been sucessfully made.The new account balance is %s",clientTransaction.getAmount(),account.getAccountBalance()));
		return new AccountBalance(account.getAccountBalance());
	}

}
