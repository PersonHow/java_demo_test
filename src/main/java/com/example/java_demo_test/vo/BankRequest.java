package com.example.java_demo_test.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BankRequest {
	private String account;
	
//	@JsonProperty("password")   
	// 當參數設定為關鍵字時，幫助外部連接找尋時，不受檢查軟體影響
	// 目前變數設定 pwd 不需使用到 
	private String pwd;
	
	private int money;

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

}
