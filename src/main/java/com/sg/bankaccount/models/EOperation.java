package com.sg.bankaccount.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum EOperation {
	@JsonProperty("Debit")
	DEPIT,
	@JsonProperty("Credit")
	CREDIT
}
