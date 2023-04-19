package com.example.java_demo_test.service.ifs;

import com.example.java_demo_test.entity.Bank;
import com.example.java_demo_test.vo.BankRequest;
import com.example.java_demo_test.vo.BankResponse;
import com.example.java_demo_test.vo.BankUpdateRequest;

public interface BankService {
	
	//增加帳號
	public BankResponse addAccount(String account, String pwd);

	//顯示帳號
	public BankResponse getAmount(BankRequest bankRequest);
	public void getAmount(Bank bank);

	//存款
	public void deposit(Bank bank, int depositAmount);
	public BankResponse deposit(BankRequest bankRequest);

	// 提款
	public void withdraw(Bank bank, int withdrawAmount);
	public BankResponse withdraw(BankRequest bankRequest);
	
	public BankResponse updatePassword(BankUpdateRequest bankUpdateRequest);
}
