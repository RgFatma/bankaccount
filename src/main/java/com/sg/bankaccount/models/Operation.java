package com.sg.bankaccount.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "operation")
public class Operation {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	@Column(name = "operation_id")
	private Long id;
	
	@Column(name="operation_name")
	@Enumerated(EnumType.STRING)
	private EOperation operationName;
	
	@Column(name="operation_amount")
	private Double operationAmount;
	
	@Column(name="operation_date")
	private Date operationDate;
	
	@Column(name="balance_after_transaction")
	private Double balanceAfterTransaction;
	
	@Column(name="description")
	private String description;
	
	@ManyToOne
	@JoinColumn(name="account_id")
	private Account account;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public Date getOperationDate() {
		return operationDate;
	}

	public void setOperationDate(Date operationDate) {
		this.operationDate = operationDate;
	}

	public Double getBalanceAfterTransaction() {
		return balanceAfterTransaction;
	}

	public void setBalanceAfterTransaction(Double balanceAfterTransaction) {
		this.balanceAfterTransaction = balanceAfterTransaction;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	
}
