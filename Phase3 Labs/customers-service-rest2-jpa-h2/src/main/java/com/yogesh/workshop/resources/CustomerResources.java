package com.yogesh.workshop.resources;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.yogesh.workshop.errors.CustomerNotFoundException;
import com.yogesh.workshop.model.Customer;
import com.yogesh.workshop.services.CustomerService;

@RestController
public class CustomerResources {

	@Autowired
	private CustomerService customerService;
	
	@GetMapping(path = "/customers")
	public List<Customer> retrieveCustomers(){
		
		return customerService.getCustomers();
	}
	
	@GetMapping(path = "/customer/{theId}")
	public Customer retrieveCustomer(@PathVariable Integer theId) {
		
		Customer theCustomer = customerService.getCustomer(theId);
		if(theCustomer==null) {
			throw new CustomerNotFoundException("id - "+ theId);
		}
		
		
		return theCustomer;
	}
	
	@PostMapping(path = "/customer")
	public ResponseEntity<Customer> createCustomer(@Valid @RequestBody Customer theCustomer) {
		Customer savedCustomer = customerService.saveCustomer(theCustomer);
		
		//location header  : http://localhost:8080/customers/4
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{theId}").buildAndExpand(savedCustomer.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping("/customers/{theId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void updateCustomer(@PathVariable Integer theId,@RequestBody Customer theCustomer) {
		Customer savedCustomer = customerService.getCustomer(theId);
		
		savedCustomer.setId(theId);
		savedCustomer.setName(theCustomer.getName());
		savedCustomer.setPhone(theCustomer.getPhone());
		savedCustomer.setEmail(theCustomer.getEmail());
		
	}
	
	@DeleteMapping("/customers/{theId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteCustomer(@PathVariable Integer theId) {
		
		@SuppressWarnings("unused")
		Customer saveCustomer = customerService.getCustomer(theId);
		
		if(saveCustomer==null) {
				throw new CustomerNotFoundException("id - "+ theId);
			
		}
		
		customerService.deleteCustomer(theId);
	}
}
