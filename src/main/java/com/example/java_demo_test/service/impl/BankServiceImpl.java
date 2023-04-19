package com.example.java_demo_test.service.impl;

import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.example.java_demo_test.entity.Bank;
import com.example.java_demo_test.repository.BankDao;
import com.example.java_demo_test.service.ifs.BankService;
import com.example.java_demo_test.vo.BankRequest;
import com.example.java_demo_test.vo.BankResponse;
import com.example.java_demo_test.vo.BankUpdateRequest;

@Service
public class BankServiceImpl implements BankService {
	
	@Autowired
	private BankDao bankDao;
	
	@Override
	public BankResponse getAmount(BankRequest bankRequest) {
		// 1. 從 DB 獲取資料並確認 (帳號、密碼)
		// 2. 確認完再去 DB 找資料的餘額

		// 目前沒資料庫，先假造資料
		Bank bank = new Bank("ABC", "A123", 1000);
		// 比對資料範例
		if (bankRequest.getAccount().equals(bank.getAccount()) && bankRequest.getPwd().equals(bank.getPwd())) {
			BankResponse response = new BankResponse(bank.getAccount(), bank.getAmount(), "成功");
			return response;
		}
		// 這行如同上面的精簡版，只是上面有特地宣告一個變數
		return new BankResponse(bank.getAccount(), null, "帳號或密碼錯誤");
	}

	@Override
	public void getAmount(Bank bank) {
		Bank bank1 = new Bank("BBC", "B123", 500);
		System.out.println(bank1.getAccount() + bank1.getAmount() + bank1.getPwd());

	}

//-------------------
	@Override
	public void deposit(Bank bank, int depositAmount) {
		System.out.printf("帳號 %s ，餘額 %d", bank.getAccount(), bank.getAmount());
		bank.setAmount(bank.getAmount() + depositAmount);
		System.out.printf("\n存款後帳號 %s ，餘額 %d", bank.getAccount(), bank.getAmount());
		System.out.println("");
	}

//	@Override
//	public BankResponse deposit(BankRequest bankRequest) {
//		Bank bank = new Bank("ABC", "A123", 1000);
//		if (checkAccountAndPwd(bankRequest, bank)) {
//			if (bankRequest.getMoney() <= 0) {
//				return new BankResponse(bank.getAccount(), "存入金額不得小於0");
//			}
//			bank.setAmount(bank.getAmount() + bankRequest.getMoney());
//			BankResponse dpsitResponse = new BankResponse(bank.getAccount(),
//					bankRequest.getMoney(), bank.getAmount(), "存入成功");
//			return dpsitResponse;
//		}
//		return new BankResponse(bank.getAccount(), "帳號密碼錯誤");
//	}

	

//-------------------
	@Override
	public void withdraw(Bank bank, int withdrawAmount) {
		if (bank.getAmount() < withdrawAmount) {
			System.out.printf("帳號 %s，提領 %d，餘額：%d", bank.getAccount(), withdrawAmount, bank.getAmount());
			System.out.print("\t餘額不足");
			System.out.println("");
		} else {
			System.out.printf("帳號 %s ，餘額 %d", bank.getAccount(), bank.getAmount());
			bank.setAmount(bank.getAmount() - withdrawAmount);
			System.out.printf("\n提領後帳號 %s，餘額：%d", bank.getAccount(), bank.getAmount());
		}
	}

//	@Override
//	public BankResponse withdraw(BankRequest bankRequest) {
//		Bank bank = new Bank("ABC", "A123", 1000);
//		if (bankRequest.getAccount().equals(bank.getAccount()) && bankRequest.getPwd().equals(bank.getPwd())
//				&& bankRequest.getMoney() <= bank.getAmount()) {
//			bank.setAmount(bank.getAmount() - bankRequest.getMoney());
//			BankResponse response = new BankResponse(bank.getAccount(),
//					bankRequest.getMoney(), bank.getAmount(), "取款成功");
//			return response;
//		} else if (bankRequest.getMoney() > bank.getAmount()) {
//			return new BankResponse(bank.getAccount(), "存款餘額不足");
//		} else {
//			return new BankResponse(bank.getAccount(), "帳號或密碼錯誤");
//		}
//	}
	
//        ====================== 簡潔優化版 =======================
	@Override
	public BankResponse deposit(BankRequest bankRequest) {
		return depositOrWithdraw(bankRequest, false);
	}
	
	@Override
	public BankResponse withdraw(BankRequest bankRequest) {
		return depositOrWithdraw(bankRequest, true);
	}
	
//-----通用方法-----
	private boolean checkAccountAndPwd (BankRequest bankRequest, Bank bank) {
		boolean result = bankRequest.getAccount().equals(bank.getAccount()) 
				&& bankRequest.getPwd().equals(bank.getPwd());
		return result ;
	}
	
	private BankResponse depositOrWithdraw(BankRequest bankRequest, boolean isWithdraw) {
		Bank bank = new Bank("ABC", "A123", 1000);
		if (checkAccountAndPwd(bankRequest,bank)) {
			if (bankRequest.getMoney() <= 0) {
				return new BankResponse(bankRequest.getAccount(), "金額錯誤");
			}
			if (isWithdraw) { // true => 提款; false => 存款
				// 提領時，要判斷提領金額不得大於存款
				if (bankRequest.getMoney() > bank.getAmount()) {
					return new BankResponse(bankRequest.getAccount(), "餘額不足");
				}
				int newAmount = bank.getAmount() - bankRequest.getMoney();
				bank.setAmount(newAmount);
				BankResponse response = new BankResponse(bank.getAccount(), 
								bankRequest.getMoney(), bank.getAmount(), "取款成功");
				return response;
			} else { // 存款
				bank.setAmount(bank.getAmount() + bankRequest.getMoney());
				return new BankResponse(bank.getAccount(), 
						bankRequest.getMoney(), bank.getAmount(), "存入成功");
			}				
		}
		return new BankResponse(bank.getAccount(), "帳號或密碼錯誤");
	}
// ======================= 新功能 0329 ========================
	@Override
	public BankResponse addAccount(String account, String pwd) {
		if(!StringUtils.hasText(account) || !StringUtils.hasText(pwd)) {
			return new BankResponse(account, "格式錯惹");
		}
		if(bankDao.existsById(account)) {
			return new BankResponse(account, "帳號已存在");
		}
		Bank bank = new Bank(account, pwd);
		Bank result = bankDao.save(bank);	
		// 因為 Entity & Service 對接橋，所以從 Service 取，送至 Entity，最後才是 DB
		if(StringUtils.hasText(result.getAccount())) {
			return new BankResponse(result.getAccount(), "這個帳號有想法!!!");
		}
		return new BankResponse(result.getAccount(), "這個帳號壞掉了");
	}
	
	@Override
	public BankResponse updatePassword(BankUpdateRequest bankUpdateRequest) {
		String reqAccount = bankUpdateRequest.getAccount();
		String reqOldPwd = bankUpdateRequest.getOldpwd();
		String reqNewPwd = bankUpdateRequest.getNewpwd();
		if(!StringUtils.hasText(reqAccount) || !StringUtils.hasText(reqOldPwd) 
				|| !StringUtils.hasText(reqNewPwd) ) {
			return new BankResponse(reqAccount,"帳號或密碼格式錯誤");
		}
		// 根據 reqAccount 檢查帳號是否存在
		Optional<Bank> op = bankDao.findById(reqAccount);
		if(!op.isPresent()) {
			return new BankResponse(reqAccount, "帳號不存在");
		}
		// 將 Optional 的 Bank 取出，( Bank存在才往下做)
		Bank bank = op.get();
		// 帳號已存在，比對舊密碼
		if(!reqOldPwd.equals(bank.getPwd())) {
			return new BankResponse(reqAccount,"帳號或密碼格式錯誤");
		}
		bank.setPwd(reqNewPwd);		// 帳號與舊密碼核對完成，就繼續新密碼更改功能
		Bank result = bankDao.save(bank);
		if(result.getPwd().equals(reqNewPwd)) {
			return new BankResponse(reqAccount, "修改密碼成功");
		}
		return new BankResponse(reqAccount, "修改密碼失敗");
	}
	
	
}
