package com.sg.bankaccount.rest.controllers.interfaces;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.sg.bankaccount.dto.ClientDto;


public interface ClientApi {
	
	@GetMapping(value="/{client_id}",produces = "application/json")
	public ClientDto getClient(@PathVariable("client_id") Long clientId);

}
