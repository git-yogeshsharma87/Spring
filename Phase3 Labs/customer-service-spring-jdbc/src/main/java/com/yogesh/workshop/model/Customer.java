package com.yogesh.workshop.model;

public class Customer {
	
	private Long id;
	private String name;
	private String phone;
	private String email;
	
	public Customer() {
		super();
	}

	public Customer(Long id, String name, String phone, String email) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.email = email;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return String.format("Customer [id=%s, name=%s, phone=%s, email=%s]", id, name, phone, email);
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	

}
