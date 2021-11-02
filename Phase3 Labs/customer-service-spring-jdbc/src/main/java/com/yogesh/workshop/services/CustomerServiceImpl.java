package com.yogesh.workshop.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yogesh.workshop.model.Customer;
import com.yogesh.workshop.repository.CustomerRepository;

import com.yogesh.workshop.repository.JdbcCustomerRepositoryImpl;

@Service(value = "customerService")
public class CustomerServiceImpl implements CustomerService {
	
	
	private CustomerRepository customerRepository;
	
	
	// note : autowire = 'byName/byType', spring looks for this no argument constructor
	public CustomerServiceImpl() {
		super();
	}


	@Autowired
	public void setCustomerRepository(CustomerRepository customerRepository) {
		System.out.println("spring container has called a 'setCustomerRepository' to assemble customerRepository bean");
		this.customerRepository = customerRepository;
	}



	public CustomerServiceImpl(CustomerRepository customerRepository) {
		super();
		System.out.println("spring container has called a 'constructor' to assemble customerRepository bean");

		this.customerRepository = customerRepository;
	}



	@Override
	public List<Customer> retrieveAllCustomers(){
		
		return customerRepository.findAll();
	}


	@Override
	public Integer countAlltheCustomers() {
		// TODO Auto-generated method stub
		return customerRepository.findNumberofCustomers();
	}
	
	

}
