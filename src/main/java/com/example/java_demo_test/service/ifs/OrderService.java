package com.example.java_demo_test.service.ifs;

import com.example.java_demo_test.entity.Menu;
//import com.example.java_demo_test.service.impl.Map;
import java.util.Map;

public interface OrderService {

	public Menu addnew(Map<String, Integer> menuMap);

//	public void addnew(Menu menu,String item,int price);

	public void orderSum(Menu menu,Map<String, Integer> orderMap);

}
