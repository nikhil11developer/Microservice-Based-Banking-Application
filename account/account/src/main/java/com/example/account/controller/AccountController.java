package com.example.account.controller;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.account.dto.AccountCreationDto;
import com.example.account.dto.ApiResponse;
import com.example.account.dto.CustomerDto;
import com.example.account.exception.InsufficientBalanceException;
import com.example.account.exception.InvalidAccountIdException;
import com.example.account.feign.CustomerFeign;
import com.example.account.model.Account;
import com.example.account.service.AccountService;



@RestController
@RequestMapping("/api/v1/account")
public class AccountController {
	
	@Autowired
	AccountService accountService;
	
	
	@Autowired
	CustomerFeign customerClient;
	
	
	@Autowired
	ModelMapper modelMapper;
	
	
	@PostMapping("/")
	public ResponseEntity<Account> createAccount(@Valid @RequestBody AccountCreationDto AccountCreationDto ) {
		CustomerDto   customerDto=modelMapper.map(AccountCreationDto, CustomerDto.class);
		CustomerDto addedCustomer=customerClient.createCustomerUsingFeign(customerDto);
		Account account = modelMapper.map(AccountCreationDto, Account.class);
		account.setCustomerId(addedCustomer.getCustomerId());
		Account addedAccount = accountService.createAccount(account);
		return new ResponseEntity<Account>(addedAccount, HttpStatus.CREATED);
	}
	
	@PutMapping("/{accountId}")
	public ResponseEntity<Account> updateAccount(@Valid @RequestBody Account account ,  @PathVariable("accountId") int accountId) throws InvalidAccountIdException, InsufficientBalanceException {
		Account updatedAccount=this.accountService.updateAccount(account, accountId);
		return new ResponseEntity<Account>(updatedAccount, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{accountId}")
	public ResponseEntity<ApiResponse> deleteAccount(@PathVariable("accountId") Integer accountId) throws InsufficientBalanceException, InvalidAccountIdException {
		this.accountService.deleteAccount(accountId);
		return new ResponseEntity<ApiResponse>(new ApiResponse("account is deleted successfully !!", true),
				HttpStatus.OK);
	}
	
	@GetMapping("/{accountId}")
	public ResponseEntity<Account> getCategory(@PathVariable("account") Integer accountId) throws InvalidAccountIdException {

		Account account = this.accountService.findByAccountId(accountId);

		return new ResponseEntity<Account>(account, HttpStatus.OK);

	}
	

}
