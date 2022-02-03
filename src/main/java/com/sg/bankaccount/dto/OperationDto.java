package com.sg.bankaccount.dto;

import com.sg.bankaccount.models.EOperation;

public class OperationDto {

	private EOperation operationName;
	private Double operationAmount;
	private String operationDate;
	private String description;
	private Double balanceAfterTransaction;
	public EOperation getOperationName() {
		return operationName;
	}
	public void setOperationName(EOperation operationName) {
		this.operationName = operationName;
	}
	public Double getOperationAmount() {
		return operationAmount;
	}
	public void setOperationAmount(Double operationAmount) {
		this.operationAmount = operationAmount;
	}
	public String getOperationDate() {
		return operationDate;
	}
	public void setOperationDate(String operationDate) {
		this.operationDate = operationDate;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Double getBalanceAfterTransaction() {
		return balanceAfterTransaction;
	}
	public void setBalanceAfterTransaction(Double balanceAfterTransaction) {
		this.balanceAfterTransaction = balanceAfterTransaction;
	}
	

}
