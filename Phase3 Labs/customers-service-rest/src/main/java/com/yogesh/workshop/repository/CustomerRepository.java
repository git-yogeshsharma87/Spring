package com.yogesh.workshop.repository;

import java.util.List;

import com.yogesh.workshop.model.Customer;

public interface CustomerRepository {

	public List<Customer> getCustomers();
	public Customer saveCustomer(Customer theCustomer);
	public Customer getCustomer(Integer theId);
	public Customer deleteCustomer(Integer theId);
}
