package com.app.ms.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Admin {
	
	@Id
	@GeneratedValue(strategy =GenerationType.AUTO)
	private long userId;
	
	private String name;
	private String email;
	private String password;
	private String userName;
	public Admin() {
		super();
	}
	public Admin(long userId, String name, String email, String password, String userName) {
		super();
		this.userId = userId;
		this.name = name;
		this.email = email;
		this.password = password;
		this.userName = userName;
	}
	
	
	// methods 
	// to login into account
	public boolean logIn() {
		
		return true;
	}
	
	// to log out from account
	public boolean logOut() {
		
		return true;
	}
	
	// view account dashboard
	public String viewAccount() {
		
		return "";
	}
	
	// to transfer funds from one account to another account
	public boolean transferFunds() {
		
		return true;
	}
	
	// to pay bills
	public boolean payBills() {
		
		return true;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
}
