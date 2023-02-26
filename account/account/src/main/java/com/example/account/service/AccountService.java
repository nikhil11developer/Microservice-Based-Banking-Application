package com.example.account.service;


import com.example.account.exception.InsufficientBalanceException;
import com.example.account.exception.InvalidAccountIdException;
import com.example.account.model.Account;

public interface AccountService {
	
	
	void deleteAccount(int accountId)  throws InsufficientBalanceException , InvalidAccountIdException;
	Account createAccount(Account account);
	Account updateAccount(Account account , int accountId)  throws InvalidAccountIdException, InsufficientBalanceException;
	Account findByAccountId(int accountId) throws InvalidAccountIdException;

}
