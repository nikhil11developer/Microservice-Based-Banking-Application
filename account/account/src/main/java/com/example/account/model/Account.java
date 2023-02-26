package com.example.account.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ACCOUNT")
public class Account {
	
	@Id
	@Column(name="ACCOUNT_ID")
	private int accountId;
	
	@Column(name="BALANCE")
	private double balance;
	
	
	
	@Column(name="CUSTOMER_ID")
	private int customerId;
	
	
	@Column(name="ACTIVE")
	private boolean active;
	
	public Account() {}

	public Account(int accountId, double balance) {
		super();
		this.accountId = accountId;
		this.balance = balance;
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public boolean Active() {
		return this.active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
	
	
	
	
}
