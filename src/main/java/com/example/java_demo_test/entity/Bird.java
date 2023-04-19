
package com.example.java_demo_test.entity;

public class Bird {
	private String name;
	private int age;
	
	public Bird() {
		
	}
	
	public Bird(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
}

