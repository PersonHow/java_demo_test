package com.example.java_demo_test.entity;

import java.util.HashMap;
import java.util.Map;

public class Menu {
	 
	private Map<String, Integer> foodMenu = new HashMap();

	public Menu() {
	
	}

	public Map<String, Integer> getFoodMenu() {
		return foodMenu;
	}

	public void setFoodMenu(Map<String, Integer> foodMenu) {
		this.foodMenu = foodMenu;
	}

	

}
