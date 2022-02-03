package com.sg.bankaccount.repositories;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.sg.bankaccount.models.Account;
import com.sg.bankaccount.models.Client;
import com.sg.bankaccount.models.Operation;

@DataJpaTest
class OperationRepositoryTest {
	
	@Autowired
	OperationRepository operationRepository;
	
	@Autowired
	private TestEntityManager entityManager;
	
	private Client client1;
	
	private Account account1;
	private Account account2;

	
	@BeforeEach
	void init() {
		
		client1 = new Client();
		client1.setFirstName("client1");
		
		
		account1 = new Account();
		account1.setAccountBalance(200.0);
		account1.setAccountNumber("0213226521005");
		account1.setClient(client1);

		
		account2 = new Account();
		account2.setAccountBalance(460.0);
		account2.setAccountNumber("02132261236001");
		account2.setClient(client1);
		
		
		Operation operation1=new Operation();
		operation1.setAccount(account1);
		
		Operation operation2=new Operation();
		operation2.setAccount(account2);
		
		Operation operation3=new Operation();
		operation3.setAccount(account1);

		entityManager.persist(client1);

		
		entityManager.persist(account1);
		entityManager.persist(account2);
		
		entityManager.persist(operation1);
		entityManager.persist(operation2);
		entityManager.persist(operation3);
		
	}
	
	@Test
	void findByAccountAccountNumberOrderByOperationDateDescTest() {
		List<Operation> operations = operationRepository.findByAccountAccountNumberOrderByOperationDateDesc("0213226521005");
		assertEquals(2, operations.size());
	}

}
