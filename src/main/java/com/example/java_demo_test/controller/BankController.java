package com.example.java_demo_test.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.java_demo_test.entity.Bank;
import com.example.java_demo_test.service.ifs.BankService;
import com.example.java_demo_test.vo.BankRequest;
import com.example.java_demo_test.vo.BankResponse;
import com.example.java_demo_test.vo.BankUpdateRequest;

@RestController
// Remember the first word is "Rest".
// When create the controller, first need to build the "@RestController"

public class BankController {
	
	@Autowired
	private BankService bankService;

//	@RequestMapping(value = "/get_amount", method = RequestMethod.POST)
	@PostMapping("/get_amount")   //上面那句的精簡版
	public BankResponse getAmount(@RequestBody BankRequest bankRequest) {
		// The RequestBody is couple of RestController,they are a team.
		BankResponse response = bankService.getAmount(bankRequest);
		return response;  
	}
	
	@PostMapping("deposit")
	public BankResponse deposit(@RequestBody BankRequest bankRequest) {
		return bankService.deposit(bankRequest);
	}
	
	@PostMapping("withdraw")
	public BankResponse withdraw(@RequestBody BankRequest bankRequest) {
		return bankService.withdraw(bankRequest);
	}
	
	@PostMapping("add_account")
	public BankResponse addAccount(@RequestBody BankRequest bankRequest) {
		return bankService.addAccount(bankRequest.getAccount(), bankRequest.getPwd());
	}
	
	@PostMapping("updatePassword")
	public BankResponse updatePassword(@RequestBody BankUpdateRequest bankUpdateRequest) {
		return bankService.updatePassword(bankUpdateRequest);
	}
}
