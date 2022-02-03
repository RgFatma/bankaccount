package com.sg.bankaccount.rest.responses;

public enum ApiError {

	INSUFFICIENT_BALANCE("Insufficient account balance","Your account balance is insufficient to complete this transaction."),
	ACCOUNT_NOT_FOUND("Resource not found", "The requested account does not exist."),
	CLIENT_NOT_FOUND("Resource not found", "The requested client does not exist.");
	
	private String message;
	private String description;

	private ApiError(String message, String description) {
		this.message = message;
		this.description = description;
	}


	public String getMessage() {
		return message;
	}

	public String getDescription() {
		return description;
	}

}
