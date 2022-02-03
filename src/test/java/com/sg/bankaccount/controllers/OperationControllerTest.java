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

import com.sg.bankaccount.rest.controllers.OperationController;
import com.sg.bankaccount.services.OperationService;

@WebMvcTest(value = OperationController.class)
@ExtendWith(SpringExtension.class)
public class OperationControllerTest {
	
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private OperationService operationService;
	
	@MockBean
	private ModelMapper modelMapper;
	
	@Test
	void displayAllOperationByAccountTest() {
		try {
			mockMvc.perform(get("/api/v1/account/00233005488387100001/operation")).andExpect(status().isOk()).andDo(print());
			
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}
	
	}
