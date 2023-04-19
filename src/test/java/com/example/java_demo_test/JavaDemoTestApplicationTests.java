package com.example.java_demo_test;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.java_demo_test.entity.Bird;
import com.example.java_demo_test.entity.Menu;
import com.example.java_demo_test.controller.BankController;
import com.example.java_demo_test.entity.Bank;
import com.example.java_demo_test.entity.Bank2;
import com.example.java_demo_test.service.ifs.Active;
import com.example.java_demo_test.service.ifs.BankService;
import com.example.java_demo_test.service.ifs.BankService2;
import com.example.java_demo_test.service.ifs.OrderService;
import com.example.java_demo_test.service.impl.ActiveImpl;
import com.example.java_demo_test.vo.BankRequest;

@SpringBootTest(classes = JavaDemoTestApplication.class)
public class JavaDemoTestApplicationTests {

	@Autowired
	private Active active;

	@Autowired
	private BankService bankservice;
	
	@Autowired
	private BankController bankController;
	
	@Autowired
	private OrderService orderservice;
	// 往後欲使用Spring boot 託管的東西必須宣告工具且記得 @Autowired
	// 每次新的都要個別宣告
	
	@Autowired
	private BankService2 bankService2;

	@Test
	public void contextLoads() {
//		Active act = new ActiveImpl();
		Bird bird = new Bird("天啊", 66);
		active.fly(bird.getName(), bird.getAge());
	}

	@Test
	public void bankServiceTest() {
		Bank bank = new Bank();
		System.out.println("---Bank初始狀態---");
		bankservice.getAmount(bank);
		System.out.println("---Deposit---");
		bankservice.deposit(bank, 2000);
		System.out.println("---Withdraw---");
		bankservice.withdraw(bank, 22000);
		System.out.println("--------");
		BankRequest bankRequest = new BankRequest();
		bankController.getAmount(bankRequest);
	}

	@Test
	public void orderTestMyself() {
		Menu menu = new Menu();
		Scanner scan = new Scanner(System.in);
		Scanner scan1 = new Scanner(System.in);
		Scanner scan2 = new Scanner(System.in);
		String item, ans;
		int num;
		Map<String, Integer> newMenuMap = new HashMap<>();
		newMenuMap.put("beef", 100);
		newMenuMap.put("pork", 80);
		newMenuMap.put("chicken", 70);
		newMenuMap.put("rabbit", 60);
//		orderservice.addnew(newMenuMap);
		menu.setFoodMenu(newMenuMap);					  // 告知 JAVA 餐館的 menu 是什麼
		Map<String, Integer> orderMap = new HashMap<>();  // 消費者的點餐訂單
		while (true) {
			System.out.print("點餐：");
			item = scan.next();
			System.out.print("幾份：");
			num = scan1.nextInt();
			orderMap.put(item, num);					  // 點餐訂單的品項加入
			System.out.println("還要繼續點餐嗎 (y / n)");
			ans = scan2.next();
			if(ans.equalsIgnoreCase("n")) {
				break;
			}
		}
		orderservice.orderSum(menu,orderMap);
	}
	

//	@Test
//	public void orderTestMyself() {
//		Menu menu = new Menu();
//		Scanner scan = new Scanner(System.in);
//		Scanner scan1 = new Scanner(System.in);
//		Scanner scan2 = new Scanner(System.in);
//		String orderfood, ans = "y";
//		int num, total = 0;
//		System.out.println(menu.getFoodMenu());
//		while (true) {
//			System.out.print("點餐：");
//			orderfood = scan.next();
//			System.out.println("幾份：");
//			num = scan1.nextInt();
//			orderservice.orderSum(menu, orderfood, num);
//			total += menu.getFoodMenu().get(orderfood) * num;
//			System.out.print("是否繼續點餐 ( y / n)");
//			ans = scan2.next();
//			if (ans.equalsIgnoreCase("y")) {
//				continue;
//			} else {
//				break;
//			}
//		}
//		System.out.printf("所有餐點共%d", total);
//		System.out.println("");
//	}

	
	@Test
	public void BankHomeWorkTest() {
		Bank2 bank2 = new Bank2();
		bank2.setAccount("Mino");
		bankService2.getAmount(bank2);
		bankService2.deposit(bank2, 10);
		bankService2.withdraw(bank2, 10);
	}
	
	
}
