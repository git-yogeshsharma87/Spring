package com.yogesh.workshop.config;

import com.yogesh.workshop.repository.*;
import com.yogesh.workshop.services.*;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.yogesh.workshop.repository.CustomerRepository;
import com.yogesh.workshop.repository.JdbcCustomerRepositoryImpl;
import com.yogesh.workshop.services.CustomerService;
import com.yogesh.workshop.services.CustomerServiceImpl;

@Configuration
@ComponentScan(basePackages="com.yogesh.workshop.repository,com.yogesh.workshop.services")
@Import(value = InfraStructureConfig.class)
public class CustomerServiceConfig {

	
	
}
	
	
