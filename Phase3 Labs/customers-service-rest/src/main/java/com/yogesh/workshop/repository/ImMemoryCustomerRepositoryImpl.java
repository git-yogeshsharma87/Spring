package com.yogesh.workshop.repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.yogesh.workshop.model.Customer;

@Repository(value = "customerRepository")
public class ImMemoryCustomerRepositoryImpl implements CustomerRepository {

	private static List<Customer> customers = new ArrayList<Customer>();
	
	// Add three customers
		static {
			customers.add(new Customer(1, "vinodh", "1234567", "vinodh@pivotal.io"));
			customers.add(new Customer(2, "bhavya", "12334456", "bhavya@collins.com"));
			customers.add(new Customer(3, "samarth", "343544", "smarth.vishnu@gmail.com"));

		}
	
		private static Integer customerCount  = 3;

	@Override
	public List<Customer> getCustomers() {
		// TODO Auto-generated method stub
		return customers;
	}

	@Override
	public Customer saveCustomer(Customer theCustomer) {
		// TODO Auto-generated method stub
		if (theCustomer.getId() == null) {
			theCustomer.setId(++customerCount);
		}
		customers.add(theCustomer); // add to list
		return theCustomer;	}

	@Override
	public Customer getCustomer(Integer theId) {
		for(Customer theCustomer: customers) {
			if(theCustomer.getId() == theId) {
				return theCustomer;
			}
		}
		return null;
	}

	@Override
	public Customer deleteCustomer(Integer theId) {
		Iterator<Customer> iterator = customers.iterator();
		while(iterator.hasNext()) {
			Customer theCustomer = iterator.next();
			if(theCustomer.getId() == theId) {
				iterator.remove();
				return theCustomer;
			}
		}
		return null;
	}

	
}
