package com.sg.bankaccount.dto;

import java.util.Set;

public class ClientDto {


	private String lastName;
	
	private String firstName;
	
	private String email;
	
	private String phone;
	
	private String address;
	
	private Set<AccountDTO> accounts;

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Set<AccountDTO> getAccounts() {
		return accounts;
	}

	public void setAccounts(Set<AccountDTO> accounts) {
		this.accounts = accounts;
	}
	
}
