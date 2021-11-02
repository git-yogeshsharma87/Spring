package com.yogesh.workshop.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;

import com.yogesh.workshop.model.Customer;
import com.yogesh.workshop.proxy.CustomerServiceRestProxy;

@Controller
public class CustomerController {

	@GetMapping(path = "/customers/list")
	public ModelAndView listOfCustumers() {
		List<Customer> customers = CustomerServiceRestProxy.retrieveCustomers();
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("list-customers"); //logical view name
		modelAndView.addObject("customers",customers);
		return modelAndView;
	}
	
	@GetMapping(path = "/customers/showFormForAdd")
	public ModelAndView showFormForAddCustomer() {
		ModelAndView modelAndView  = new ModelAndView();
		modelAndView.setViewName("customer-form");
		Customer theCustomer = new Customer();
		modelAndView.addObject("customer",theCustomer);
		return modelAndView;
	}
	
	@PostMapping (path = "/customers/saveCustomer")
	public ModelAndView saveCustomer(@ModelAttribute("customer") Customer theCustomer) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("redirect:/customers/list");
		customerServiceRestProxy.createCustomer(theCustomer);
		return modelAndView;
	}
	
}
