package com.example.account.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.account.dto.CustomerDto;

@FeignClient(name = "customerClient", url = "localhost:8082", path = "/api/v1/auth")
public interface CustomerFeign {
	
	@PostMapping("/")
    CustomerDto createCustomerUsingFeign(CustomerDto customerDto);

}
