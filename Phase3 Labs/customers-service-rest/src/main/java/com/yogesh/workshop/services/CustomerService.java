package com.yogesh.workshop.services;

import java.util.List;

import com.yogesh.workshop.model.Customer;

public interface CustomerService {

	public List<Customer> getCustomers();
	public Customer saveCustomer(Customer theCustomer);
	public Customer getCustomer(Integer theId);
	public Customer deleteCustomer(Integer theId);
	
}
