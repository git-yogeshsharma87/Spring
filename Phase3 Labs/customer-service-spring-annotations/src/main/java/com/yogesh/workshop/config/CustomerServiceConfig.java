package com.yogesh.workshop.config;

import com.yogesh.workshop.repository.*;
import com.yogesh.workshop.services.*;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.yogesh.workshop.repository.CustomerRepository;
import com.yogesh.workshop.repository.InMemoryCustomerRepositoryImpl;
import com.yogesh.workshop.services.CustomerService;
import com.yogesh.workshop.services.CustomerServiceImpl;

@Configuration
@ComponentScan(basePackages="com.yogesh.workshop.repository,com.yogesh.workshop.services")
public class CustomerServiceConfig {
	

	
	
}
