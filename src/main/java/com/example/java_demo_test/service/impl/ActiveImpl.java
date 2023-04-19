package com.example.java_demo_test.service.impl;

import org.springframework.stereotype.Service;

import com.example.java_demo_test.service.ifs.Active;

@Service
// 普遍會下在實作的地方
public class ActiveImpl implements Active {
	
	@Override
	public void fly(String name, int age) {
		// TODO Auto-generated method stub

		System.out.printf("今年 %d 歲，%s正在飛", age, name);
	}

}
