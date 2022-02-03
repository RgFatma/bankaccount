package com.sg.bankaccount.rest.responses;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AccountBalance {

	@JsonProperty("new_amount")
	private Double amount;
	
	public AccountBalance(Double amount) {
		this.amount=amount;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}
	
}
