package com.sg.bankaccount.exceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.sg.bankaccount.exceptions.BadRequestException;
import com.sg.bankaccount.exceptions.RessourceNotFoundException;
import com.sg.bankaccount.rest.responses.ErrorResponse;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(BadRequestException.class)
	public ResponseEntity<ErrorResponse> badRequestException(BadRequestException ex) {
		return new ResponseEntity<>(ex.getError(), HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(RessourceNotFoundException.class)
	public ResponseEntity<ErrorResponse> ressourceNotFoundException(RessourceNotFoundException ex) {
		return new ResponseEntity<>(ex.getError(), HttpStatus.NOT_FOUND);
	}

}
