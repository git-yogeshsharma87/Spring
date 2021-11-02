package com.yogesh.workshop.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;
import javax.swing.tree.RowMapper;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.yogesh.workshop.model.Customer;

// provide value as interface name 
@Repository(value = "CustomerRepository")
public class JdbcCustomerRepositoryImpl implements CustomerRepository {
	private static final String SQL_CUSTOMERS_COUNT = "select count(*) from customers";
	private static final String SQL_CUSTOMERS_SELECT = "select * from customers";
	private JdbcTemplate jdbcTemplate;
	
	public JdbcCustomerRepositoryImpl(DataSource dataSource) {
		System.out.println("spring has assemled a datasource bean for us .. ");
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public List<Customer> findAll() {
		return jdbcTemplate.query(SQL_CUSTOMERS_SELECT,new CustomerRowMapper());
	}
	


	@Override
	public Integer findNumberofCustomers() {
		// TODO Auto-generated method stub
		return jdbcTemplate.queryForObject(SQL_CUSTOMERS_COUNT,Integer.class);
	}
}


class CustomerRowMapper implements org.springframework.jdbc.core.RowMapper<Customer>{
	
	Customer customer = new Customer();

	@Override
	public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub

	customer.setId(rs.getLong("id"));
	customer.setName(rs.getString("name"));
	customer.setPhone(rs.getString("phone"));
	customer.setEmail(rs.getString("email"));
	return customer;
	
	
}
}