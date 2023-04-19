package com.example.java_demo_test.service.ifs;

import com.example.java_demo_test.entity.Bank2;

public interface BankService2 {
//0324 homework 
	public void getAmount(Bank2 bank2);
	
	public void deposit(Bank2 bank2, int depositAmount);
	
	public void withdraw(Bank2 bank2, int withdrawAmount);
}
