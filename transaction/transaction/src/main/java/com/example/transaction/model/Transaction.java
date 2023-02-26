package com.example.transaction.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.example.transaction.utils.Operation;


@Entity
@Table(name="TRANSACTION")
public class Transaction{
	
	@Id
	@Column(name="TRANSACTION_ID")
	@GeneratedValue(strategy =  GenerationType.AUTO)
	private int transactionId;
	
	@Column(name="TRANSACTION_DATE")
	private Date transactionDate;
	
	@Column(name="TRANSACTION_TYPE")
	private Operation transactionType;
	
	@Column(name="TRANSACTION_AMOUNT")
	private double transactionAmount;
	
	@Column(name="BALANCE")
	private double balance;
	
	
	@Column(name="ACCOUNT_ID")
	private int accountId;

	public Transaction() {
		
	}

	public Transaction(Date transactionDate, Operation transactionType, double transactionAmount , double balance , int accountId) {
		super();
		this.transactionDate = transactionDate;
		this.transactionType = transactionType;
		this.transactionAmount = transactionAmount;
		this.balance=balance;
		this.accountId=accountId;
	}

	public Date getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	public Operation getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(Operation transactionType) {
		this.transactionType = transactionType;
	}

	public double getTransactionAmount() {
		return transactionAmount;
	}

	public void setTransactionAmount(double transactionAmount) {
		this.transactionAmount = transactionAmount;
	}
	
	

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	

	public int getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	@Override
	public String toString() {
		return "Transaction [transactionDate=" + transactionDate + ", transactionType=" + transactionType
				+ ", transactionAmount=" + transactionAmount + ", balance=" + balance + "]\n==========";
	}

	

	
	
	

}
