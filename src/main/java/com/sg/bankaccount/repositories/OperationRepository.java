package com.sg.bankaccount.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sg.bankaccount.models.Operation;

@Repository
public interface OperationRepository  extends JpaRepository<Operation , Long>{
	
	List<Operation> findByAccountAccountNumberOrderByOperationDateDesc(String accountNumber);

}
