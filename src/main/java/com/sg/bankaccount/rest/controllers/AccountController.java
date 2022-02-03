package com.sg.bankaccount.rest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sg.bankaccount.rest.controllers.interfaces.AccountApi;
import com.sg.bankaccount.rest.requests.ClientTransaction;
import com.sg.bankaccount.rest.responses.AccountBalance;
import com.sg.bankaccount.services.AccountService;

@RestController
@RequestMapping("/api/v1/account")
public class AccountController implements AccountApi{

	@Autowired
	AccountService accountService;

	@Override
	public AccountBalance  depositAmount(ClientTransaction clientTransaction) {
		return accountService.depositAccount(clientTransaction);
	}

	@Override
	public AccountBalance retreiveAmount(ClientTransaction clientTransaction) {
		return accountService.withdrawalFromAccount(clientTransaction);
	}

}
