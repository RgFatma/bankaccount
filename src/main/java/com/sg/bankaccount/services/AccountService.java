package com.sg.bankaccount.services;

import com.sg.bankaccount.rest.requests.ClientTransaction;
import com.sg.bankaccount.rest.responses.AccountBalance;

public interface AccountService {
	
	AccountBalance depositAccount(ClientTransaction clientTransaction);
	AccountBalance withdrawalFromAccount(ClientTransaction clientTransaction);
}
