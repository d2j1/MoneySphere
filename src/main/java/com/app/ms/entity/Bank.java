package com.app.ms.entity;

import java.util.ArrayList;
import java.util.List;

public class Bank {

	
	private int id;
	private String bankName;
	private String loaction;
	
	
	
	
	public Bank() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Bank(String bankName, String loaction) {
		super();
		this.bankName = bankName;
		this.loaction = loaction;
	}

	// methods
	public List<String> GetBranches(){
		
		return new ArrayList<String>();
	}
	
	public List<String> GetATMs(){
		
		return new ArrayList<String> ();
		
	}
	
	public List<String> GetServices(){
		return new ArrayList<String>();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getLoaction() {
		return loaction;
	}

	public void setLoaction(String loaction) {
		this.loaction = loaction;
	}
	
	
	
}
