package com.sg.bankaccount.controllers;

import static org.junit.jupiter.api.Assertions.fail;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import com.sg.bankaccount.rest.controllers.ClientController;
import com.sg.bankaccount.services.ClientService;

@WebMvcTest(value = ClientController.class)
@ExtendWith(SpringExtension.class)
class ClientControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private ClientService clientService;
	
	@MockBean
	private ModelMapper modelMapper;

	@Test
	void getClientTest() {
		try {
			mockMvc.perform(get("/api/v1/client/1")).andExpect(status().isOk()).andDo(print());
			
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}

}
