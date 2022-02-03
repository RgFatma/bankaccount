package com.sg.bankaccount.exceptions;

import com.sg.bankaccount.rest.responses.ErrorResponse;

public class BadRequestException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private final transient ErrorResponse error;

	public BadRequestException(ErrorResponse error) {
		super(error.getDescription());
		this.error = error;
	}

	public ErrorResponse getError() {
		return error;
	}
}
