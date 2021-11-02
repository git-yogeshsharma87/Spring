package com.yogesh.workshop.repository;

import java.util.List;

import com.yogesh.workshop.model.Customer;

public interface CustomerRepository {
	
	public Integer findNumberofCustomers();
	
	
	public List<Customer> findAll();
	

}
