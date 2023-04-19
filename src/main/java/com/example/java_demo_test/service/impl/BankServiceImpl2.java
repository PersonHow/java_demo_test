package com.example.java_demo_test.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.example.java_demo_test.entity.Bank2;
import com.example.java_demo_test.service.ifs.BankService2;

@Service
public class BankServiceImpl2 implements BankService2 {
//0324 homework


	public void getAmount(Bank2 bank2) {
		System.out.printf("顯示帳號:%s + 餘額 %d", bank2.getAccount(), bank2.getAmount());
		System.out.println("");
	}

	public void deposit(Bank2 bank2, int depositAmount) {
		if (StringUtils.hasText(bank2.getAccount()) && depositAmount > 0 ) {
			bank2.setAmount(bank2.getAmount() + depositAmount);
			System.out.printf("顯示帳號:%s + 餘額 %d", bank2.getAccount(), bank2.getAmount());
			System.out.printf(" 已存入 %d", depositAmount);
			System.out.println("");
		} else {
			System.out.println("帳號錯誤或是存入金額錯誤");
		}
	}

	public void withdraw(Bank2 bank2, int withdrawAmount) {
		if (!StringUtils.hasText(bank2.getAccount())){
			System.out.println("帳號錯誤");
			return;
		}
		if(withdrawAmount < 0 ) {
			System.out.println("金額錯誤");
			return;
		}
		if(bank2.getAmount() < withdrawAmount) {
			System.out.println("金額不足");
			return;
		}
		bank2.setAmount(bank2.getAmount() - withdrawAmount);
		System.out.printf("顯示帳號:%s + 餘額 %d", bank2.getAccount(), bank2.getAmount());
		System.out.println("已提領: " + withdrawAmount);
	}
}
