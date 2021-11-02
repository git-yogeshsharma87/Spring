package com.yogesh.workshop;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yogesh.workshop.config.CustomerServiceConfig;
import com.yogesh.workshop.model.Customer;
import com.yogesh.workshop.services.CustomerService;
import com.yogesh.workshop.services.CustomerServiceImpl;

public class CustomerServiceApplication {

	public static void main(String[] args) {

		// spring container 
		//ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(CustomerServiceConfig.class);
//		System.out.println("My name is Yogesh");
		// depends on customer service
		//CustomerService customerService = new CustomerServiceImpl();
		
		CustomerService customerService = applicationContext.getBean("customerService",CustomerService.class);
		System.out.println("The number of customer in the database are  : "+ customerService.countAlltheCustomers());
		
		
		List<Customer> loadedCustomers = customerService.retrieveAllCustomers();
	/*	
		for(Customer element : loadedCustomers) {
			
			System.out.println(element.getName());
		}*/

		loadedCustomers.forEach(element -> System.out.println(element.getName()));
		
	}

}
