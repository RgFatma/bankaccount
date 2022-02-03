package com.sg.bankaccount.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sg.bankaccount.exceptions.RessourceNotFoundException;
import com.sg.bankaccount.models.Client;
import com.sg.bankaccount.repositories.ClientRepository;
import com.sg.bankaccount.rest.responses.ApiError;
import com.sg.bankaccount.rest.responses.ErrorResponse;
import com.sg.bankaccount.services.ClientService;

@Service
public class ClientServiceImpl implements ClientService{
	
	@Autowired
	private ClientRepository clientRepository;

	@Override
	public Client findClientById(Long clientId) {

		return clientRepository.findById(clientId)
				.orElseThrow(() -> new RessourceNotFoundException(new ErrorResponse(ApiError.CLIENT_NOT_FOUND.getMessage(),
						ApiError.CLIENT_NOT_FOUND.getDescription())));
	}

}
