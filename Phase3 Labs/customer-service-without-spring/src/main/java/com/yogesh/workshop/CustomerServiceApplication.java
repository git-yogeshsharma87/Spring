package com.yogesh.workshop;

import java.util.List;

import com.yogesh.workshop.model.Customer;
import com.yogesh.workshop.services.CustomerService;
import com.yogesh.workshop.services.CustomerServiceImpl;

public class CustomerServiceApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		CustomerService customerService = new CustomerServiceImpl();
		
		List<Customer> loadedCustomers = customerService.retrieveAllCustomers();
	/*	
		for(Customer element : loadedCustomers) {
			
			System.out.println(element.getName());
		}*/

		loadedCustomers.forEach(element -> System.out.println(element.getName()));
		
	}

}
