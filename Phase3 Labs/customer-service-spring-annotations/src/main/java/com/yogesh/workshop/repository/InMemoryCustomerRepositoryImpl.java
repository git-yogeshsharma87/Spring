package com.yogesh.workshop.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.yogesh.workshop.model.Customer;

// provide value as interface name 
@Repository(value = "CustomerRepository")
public class InMemoryCustomerRepositoryImpl implements CustomerRepository {
	
	private static List<Customer> customers = new ArrayList<>();
	

	static {
		
		customers.add(new Customer(1L,"vinodh", "1234567890","vinodh@pivotal.com"));
		customers.add(new Customer(2L,"bhavya", "1234567890","bhavya@collins.com"));
		customers.add(new Customer(3L,"samarth", "1234567890","samarth@google.com"));

	}
	
	@Override
	public List<Customer> findAll() {
		return customers;
	}
	
}
