package com.example.java_demo_test.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.springframework.stereotype.Service;

import com.example.java_demo_test.entity.Menu;
import com.example.java_demo_test.service.ifs.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

	@Override
	public Menu addnew(Map<String, Integer> menuMap) {
		Menu menu = new Menu();
		menu.setFoodMenu(menuMap);
		return menu;
	}
//	public void addnew(Menu menu, String item, int price) {
//		if (menu.getFoodMenu().containsKey(item)) {
//			System.out.println("已有品項");
//		} else {
//			menu.getFoodMenu().put(item, price);
//		}
//		// TODO Auto-generated method stub
//	}

	@Override
	public void orderSum(Menu menu,Map<String, Integer> orderMap) { // 餐館的 menu 與 消費者的訂單
		int total = 0;
		for(Map.Entry<String,Integer> item:orderMap.entrySet()) {
			String menufood = item.getKey();					// 點餐的Map，這邊是傳餐點名稱
			int num = item.getValue();							// 點餐的Map，這邊是傳餐點數量
			Map<String, Integer> menuMap = menu.getFoodMenu();
			int price = menuMap.get(menufood);					// 找到與餐館餐點的價格
			int priceSum = price * num;							// 該品項總額
			System.out.printf("%s，%d份，共%d元",menufood,num,priceSum);
			System.out.println("");
			total += priceSum;									// 整張單的總額
		}
		if(total > 500) {
			total = (total/10)*9;
			System.out.println("所有餐點共："+ total);
			return;
		}
//		System.out.println(orderMap);
		System.out.println("所有餐點共："+ total);
	}
//	@Override
//	public void orderSum(Menu menu, String item, int num) {
//		// TODO Auto-generated method stub
//			int sum = 0;
//			sum = menu.getFoodMenu().get(item) * num;
//			if (sum > 500) {
//				sum = (sum / 10) * 9;
//			}
//			System.out.printf("餐點%s，有%d份，該餐點共%d", item, num, sum);
//			System.out.println("");
//		}

}
