package com.sg.bankaccount.rest.controllers.interfaces;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.sg.bankaccount.dto.OperationDto;

public interface OperationApi {

	
	@GetMapping(produces = "application/json")
	public List<OperationDto> displayAllOperationByAccount(@PathVariable("account_number") String accountNumber);
	
}
