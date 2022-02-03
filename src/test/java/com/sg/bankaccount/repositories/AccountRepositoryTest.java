package com.sg.bankaccount.repositories;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.sg.bankaccount.models.Account;
import com.sg.bankaccount.models.Client;

@DataJpaTest
class AccountRepositoryTest {
	
	@Autowired
	AccountRepository accountRepository;
	
	@Autowired
	private TestEntityManager entityManager;
	
	private Client client1;
	private Client client2;
	
	private Account account1;
	private Account account2;
	private Account account3;
	
	@BeforeEach
	void init() {
		
		client1 = new Client();
		client1.setFirstName("client1");
		
		client2 = new Client();
		client2.setFirstName("client2");
		
		account1 = new Account();
		account1.setAccountBalance(200.0);
		account1.setClient(client1);
		account1.setAccountNumber("0213226521005");

		
		account2 = new Account();
		account2.setAccountBalance(460.0);
		account2.setClient(client2);
		account2.setAccountNumber("02132261236001");
		
		account3 = new Account();
		account3.setAccountBalance(790.0);
		account3.setClient(client1);
		account3.setAccountNumber("0523212510533");
		
		entityManager.persist(client1);
		entityManager.persist(client2);
		
		entityManager.persist(account1);
		entityManager.persist(account2);
		entityManager.persist(account3);
	}
	
	@Test
	void findByAccountNumberTest() {
		Optional<Account> returnedAccount = accountRepository.findByAccountNumber("02132261236001");
		assertEquals(460.0, returnedAccount.get().getAccountBalance());
	}
}
