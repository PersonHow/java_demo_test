package com.example.java_demo_test.vo;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class BankResponse {

	private String account;
	
	private Integer money;

	private Integer amount;

	private String message;

	
	public BankResponse() {

	}
	
	public BankResponse(String account, String message) {
		this.account = account;
		this.message = message;
	}

	public BankResponse(String account, Integer amount) {
		this.account = account;
		this.amount = amount;
	}

	public BankResponse(String account, Integer amount, String message) {
		this.account = account;
		this.amount = amount;
		this.message = message;
	}

	public BankResponse(String account, Integer money, Integer amount, String message) {
		this.account = account;
		this.amount = amount;
		this.message = message;
		this.money = money;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Integer getMoney() {
		return money;
	}

	public void setMoney(Integer money) {
		this.money = money;
	}

}
