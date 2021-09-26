package com.yog.shop;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_user")
public class User {

	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String userId;
	private String name;
	private String family;
	//private String username;
//	private String password;
	private Address userAddress;
	private Account account;
	public String getUserId() {
		return userId;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFamily() {
		return family;
	}
	public void setFamily(String family) {
		this.family = family;
	}

	/*
	 * public String getUsername() { return username; } public void
	 * setUsername(String username) { this.username = username; } public String
	 * getPassword() { return password; }
	 */
	/*
	 * public void setPassword(String password) { this.password = password; }
	 */
	public Address getUserAddress() {
		return userAddress;
	}
	public void setUserAddress(Address userAddress) {
		this.userAddress = userAddress;
	}
	public User(String name, String family, Address userAddress, Account account) {
		super();
		this.name = name;
		this.family = family;
		//this.username = username;
//		this.password = password;
		this.userAddress = userAddress;
		this.account = account;
	}
	
	
}
