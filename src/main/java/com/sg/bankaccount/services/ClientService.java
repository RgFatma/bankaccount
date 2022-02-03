package com.sg.bankaccount.services;

import com.sg.bankaccount.models.Client;

public interface ClientService {

	Client findClientById(Long clientId);
}
