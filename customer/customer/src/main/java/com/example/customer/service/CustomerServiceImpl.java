package com.example.customer.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.customer.dto.CustomerDto;
import com.example.customer.dto.LoginDto;
import com.example.customer.model.Customer;
import com.example.customer.repository.CustomerRepository;


@Service
public class CustomerServiceImpl    implements CustomerService{
	
	@Autowired
	CustomerRepository customerRepository;
	
	
	@Autowired
	ModelMapper modelMapper;


	@Override
	public CustomerDto createCustomer(CustomerDto customerDto) {
		Customer customer =modelMapper.map(customerDto, Customer.class);
		Customer addedCustomer=customerRepository.save(customer);
		return modelMapper.map(addedCustomer, CustomerDto.class);
	}


	@Override
	public boolean isCustomerValid(LoginDto loginDto) {
		return this.customerRepository.findByEmailAndPassword(loginDto.getEmail(), loginDto.getPassword())!=null;
	}
	
	

}
