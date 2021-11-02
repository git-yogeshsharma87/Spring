package com.yogesh.workshop.services;

import java.util.List;

import com.yogesh.workshop.model.Customer;
import com.yogesh.workshop.repository.CustomerRepository;

import com.yogesh.workshop.repository.InMemoryCustomerRepositoryImpl;

public class CustomerServiceImpl implements CustomerService {
	
	
	private CustomerRepository customerRepository = new InMemoryCustomerRepositoryImpl();
	
	@Override
	public List<Customer> retrieveAllCustomers(){
		
		return customerRepository.findAll();
	}
	
	

}
