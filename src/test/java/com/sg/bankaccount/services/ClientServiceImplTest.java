package com.sg.bankaccount.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.sg.bankaccount.exceptions.RessourceNotFoundException;
import com.sg.bankaccount.models.Client;
import com.sg.bankaccount.repositories.ClientRepository;
import com.sg.bankaccount.services.impl.ClientServiceImpl;


@SpringJUnitConfig(classes =ClientServiceImpl.class)
class ClientServiceImplTest {
	
	@Autowired
	ClientServiceImpl clientServiceImpl;
	 
	@MockBean
	private ClientRepository clientRepository;
	
	@Test
	void findClientByIdOK() {
		Client client = new Client();
		client.setId(1l);
		
		Mockito.when(clientRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(client));
		
		Client clientReturned=clientServiceImpl.findClientById(1l);
		
		assertEquals(1l, clientReturned.getId());
		
	}
	
	@Test
	void findClientByIdNotFound() {

		Mockito.when(clientRepository.findById(Mockito.anyLong())).thenReturn(Optional.empty());
				
		RessourceNotFoundException exception = assertThrows(RessourceNotFoundException.class,
				() -> clientServiceImpl.findClientById(1l));
		assertTrue(exception.getMessage().contains("The requested client does not exist."));
		
	}

}
