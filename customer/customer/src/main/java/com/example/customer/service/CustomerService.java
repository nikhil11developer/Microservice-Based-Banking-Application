package com.example.customer.service;

import com.example.customer.dto.CustomerDto;
import com.example.customer.dto.LoginDto;

public interface CustomerService {
    public CustomerDto createCustomer(CustomerDto customerDto);
    public boolean isCustomerValid(LoginDto loginDto);
}
