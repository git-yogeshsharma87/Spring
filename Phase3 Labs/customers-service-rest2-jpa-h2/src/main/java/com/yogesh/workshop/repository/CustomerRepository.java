package com.yogesh.workshop.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.yogesh.workshop.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{

}
