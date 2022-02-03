package com.sg.bankaccount.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sg.bankaccount.models.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long>{

}
