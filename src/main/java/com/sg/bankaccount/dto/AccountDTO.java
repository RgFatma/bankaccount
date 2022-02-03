package com.sg.bankaccount.dto;


import com.sg.bankaccount.models.EAccountType;

public class AccountDTO {
	
	private String accountNumber;

	private EAccountType accountType;
	
	private Double accountBalance;

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public EAccountType getAccountType() {
		return accountType;
	}

	public void setAccountType(EAccountType accountType) {
		this.accountType = accountType;
	}

	public Double getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(Double accountBalance) {
		this.accountBalance = accountBalance;
	}

	
}
