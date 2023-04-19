package com.example.java_demo_test.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity							// 告知 JAVA 這是 Entity，能與資料庫連結或對應
@Table(name = "bank")			// 連結 MySQL 中 "bank" 的這個 Table
public class Bank {
	
	@Id							// 表示這個屬性具備 MySQL 的 PK (Primary Key) 且僅有單一主健
	@Column(name = "account")	// 連結 MySQL 中 Table 中的 account 欄位
	private String account ;
	
	@Column(name = "pwd")
	private String pwd;
	
	@Column(name = "amount")
	private int amount ;

	public Bank() {

	}

	public Bank(String account, int amount) {
		this.account = account;
		this.amount = amount;
	}
	
	public Bank(String account, String pwd) {
		this.account = account;
		this.pwd = pwd;
	}


	public Bank(String account, String pwd, int amount) {
		this.account = account;
		this.pwd = pwd;
		this.amount = amount;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
}
