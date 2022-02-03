package com.sg.bankaccount.rest.controllers.interfaces;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.sg.bankaccount.rest.requests.ClientTransaction;
import com.sg.bankaccount.rest.responses.AccountBalance;

import org.springframework.http.HttpStatus;

public interface AccountApi {

	@PostMapping(value="/deposit", consumes = "application/json")
	@ResponseStatus(HttpStatus.OK)
	AccountBalance depositAmount(@RequestBody ClientTransaction clientTransaction );
	
	@PostMapping(value="/retreive", consumes = "application/json")
	@ResponseStatus(HttpStatus.OK)
	AccountBalance retreiveAmount(@RequestBody ClientTransaction clientTransaction );
	
}
