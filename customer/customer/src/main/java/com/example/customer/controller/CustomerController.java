package com.example.customer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.customer.dto.ApiResponse;
import com.example.customer.dto.CustomerDto;
import com.example.customer.dto.LoginDto;
import com.example.customer.service.CustomerService;
import javax.validation.Valid;


@RestController
@RequestMapping("/api/v1/auth")
public class CustomerController {
	
	
	@Autowired
	CustomerService customerService;
	
	@PostMapping("/")
	public ResponseEntity<CustomerDto> createCustomer(@Valid @RequestBody CustomerDto customerDto) {
		CustomerDto customer = this.customerService.createCustomer(customerDto);
		return new ResponseEntity<CustomerDto>(customer, HttpStatus.CREATED);
	}
	
	
	@PostMapping("/isValidCustomer")
	public ResponseEntity<ApiResponse> isCustomerValid(@RequestBody LoginDto loginDto) {
		boolean valid = this.customerService.isCustomerValid(loginDto);
		return new ResponseEntity<ApiResponse>(new ApiResponse(valid, ""), HttpStatus.OK);
	}


}
