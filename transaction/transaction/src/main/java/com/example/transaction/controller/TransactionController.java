package com.example.transaction.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.transaction.model.Transaction;
import com.example.transaction.service.TransactionService;

@RestController
@RequestMapping("/api/v1/transaction")
public class TransactionController {
	
	
	@Autowired
	TransactionService transactionService;
	
	@PostMapping("/")
	public ResponseEntity<Transaction> createTransaction(@RequestBody Transaction transaction) {
		Transaction createdTransaction = this.transactionService.createTransaction(transaction);
		return new ResponseEntity<Transaction>(createdTransaction, HttpStatus.CREATED);
	}

}
