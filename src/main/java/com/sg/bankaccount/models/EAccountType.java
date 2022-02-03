package com.sg.bankaccount.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum EAccountType {
	@JsonProperty("Courant")
	COURANT, @JsonProperty("Epargne")
	EPARGNE
}
