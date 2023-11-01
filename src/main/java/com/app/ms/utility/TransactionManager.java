package com.app.ms.utility;

import com.app.ms.entity.Transactions;

public class TransactionManager {

	
	public Transactions createTransaction() {
		
		return new Transactions();
	}
	
	public Transactions ProcessTransaction() {
		return new Transactions();
	}
	public boolean verifyFunds(){
		
		return false;
	}
	
	public boolean updateBalances()
	{
		return false;
	}
	
	
}
