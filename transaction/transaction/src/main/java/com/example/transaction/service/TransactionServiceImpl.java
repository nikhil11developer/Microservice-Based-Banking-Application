package com.example.transaction.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.transaction.model.Transaction;
import com.example.transaction.repository.TransactionRepository;

public class TransactionServiceImpl   implements TransactionService{
	
	@Autowired
	TransactionRepository transactionRespository;

	@Override
	public Transaction createTransaction(Transaction transaction) {
		return this.transactionRespository.save(transaction);
	}

}
