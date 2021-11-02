package com.yogesh.workshop.config;


import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class InfraStructureConfig {

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new  DriverManagerDataSource();
		
		String url = "jdbc:mysql://localhost:3306/studentdb?allowPublicKeyRetrieval=true&useSSL=false";
		String user = "root";
		String password = "Jsr@30071987";
		String driverClassName = "com.mysql.cj.jdbc.Driver";
		
		dataSource.setDriverClassName(driverClassName);
		dataSource.setUrl(url);
		dataSource.setUsername(user);
		dataSource.setPassword(password);
		
		return dataSource;
}

	
}
