package com.yogesh.workshop.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.yogesh.workshop.repository.CustomerRepository;
import com.yogesh.workshop.repository.InMemoryCustomerRepositoryImpl;
import com.yogesh.workshop.services.CustomerService;
import com.yogesh.workshop.services.CustomerServiceImpl;

@Configuration
public class CustomerServiceConfig {
	
	@Bean
	public CustomerRepository customerRespository() {
		
		return new InMemoryCustomerRepositoryImpl();
	}
	
	@Bean
	@Scope("singleton")
	public CustomerService customerService() {
		CustomerServiceImpl customerService = new CustomerServiceImpl();
		customerService.setCustomerRepository(customerRespository());
	return customerService;
	}

}
