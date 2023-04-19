package com.example.java_demo_test.vo;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class PersonInfoResponseA {

	private String id;

	private String name;

	private Integer age;

	private String message;
	
	public PersonInfoResponseA() {
		
	}

	public PersonInfoResponseA(String id, String message) {
		this.id = id;
		this.message = message;
	}

	public PersonInfoResponseA(String id, String name, Integer age) {
		this.id = id;
		this.name = name;
		this.age = age;
	}

	public PersonInfoResponseA(String id, String name, String message) {
		this.id = id;
		this.name = name;
		this.message = message;
	}

	public PersonInfoResponseA(String id, String name, Integer age, String message) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.message = message;
	
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
