package com.app.ms.entity;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Component
@Entity
public class Account {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long accountId;
	
	private AccountType accountType;
	
	private long balance;

	public Account() {
		super();
	}
	
	
	
	
	public Account(long accountId, AccountType accountType, long balance) {
		super();
		this.accountId = accountId;
		this.accountType = accountType;
		this.balance = balance;
	}




	// methods 
	// to deposit 
	public long deposit(long amount) {
		
		balance += amount;
		return amount;
	}

	public long withdraw(long amount) {
		
		balance -= amount;
		return amount;
	}
	
	
	public long getAccountId() {
		return accountId;
	}

	public void setAccountId(long accountId) {
		this.accountId = accountId;
	}

	

	public AccountType getAccountType() {
		return accountType;
	}

	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}

	public long getBalance() {
		return balance;
	}

	public void setBalance(long balance) {
		this.balance = balance;
	}




	@Override
	public String toString() {
		return "Account [accountId=" + accountId + ", accountType=" + accountType + ", balance=" + balance + "]";
	}
	
	
	
}
