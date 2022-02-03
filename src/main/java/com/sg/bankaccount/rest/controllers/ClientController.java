package com.sg.bankaccount.rest.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sg.bankaccount.dto.ClientDto;
import com.sg.bankaccount.models.Client;
import com.sg.bankaccount.rest.controllers.interfaces.ClientApi;
import com.sg.bankaccount.services.ClientService;


@RestController
@RequestMapping("/api/v1/client/")
public class ClientController implements ClientApi{
	
	@Autowired
	private ClientService clientService;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public ClientDto getClient(Long clientId) {
		return convertToDTO(clientService.findClientById(clientId));
	}
	
	private ClientDto convertToDTO(Client client) {
		return modelMapper.map(client, ClientDto.class);
	}
	
}
