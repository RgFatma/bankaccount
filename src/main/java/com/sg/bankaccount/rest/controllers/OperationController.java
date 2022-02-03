package com.sg.bankaccount.rest.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sg.bankaccount.dto.OperationDto;
import com.sg.bankaccount.models.Operation;
import com.sg.bankaccount.rest.controllers.interfaces.OperationApi;
import com.sg.bankaccount.services.OperationService;

@RestController
@RequestMapping("/api/v1/account/{account_number}/operation")
public class OperationController implements OperationApi{
	
	@Autowired 
	private OperationService operationService;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public List<OperationDto> displayAllOperationByAccount(String accountNumber) {
	
		return operationService.displayOperationsByAccount(accountNumber).stream().map(this::convertToDTO).collect(Collectors.toList());
	}
	
	private OperationDto convertToDTO(Operation operation) {
		return modelMapper.map(operation, OperationDto.class);
	}
	

}
