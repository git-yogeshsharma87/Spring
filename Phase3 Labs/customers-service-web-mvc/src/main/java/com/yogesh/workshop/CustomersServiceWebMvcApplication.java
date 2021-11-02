package com.yogesh.workshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class CustomersServiceWebMvcApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomersServiceWebMvcApplication.class, args);
	}

}
