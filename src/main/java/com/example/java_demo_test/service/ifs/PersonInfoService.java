package com.example.java_demo_test.service.ifs;

import java.util.List;

import com.example.java_demo_test.entity.PersonInfo;
import com.example.java_demo_test.vo.PersonInfoRequestA;
import com.example.java_demo_test.vo.PersonInfoResponse;
import com.example.java_demo_test.vo.PersonInfoRequest;
import com.example.java_demo_test.vo.PersonInfoResponseA;

public interface PersonInfoService {
	
	public PersonInfoResponseA addPersonInfo(PersonInfoRequestA persionInfoAddRequest);
	public PersonInfoResponse addPersonInfo(PersonInfoRequest request);

	public List<PersonInfo> getPersonInfo();
	
	public PersonInfoResponseA getPersonInfoById(String id);
	
	public List<PersonInfo> getPersonInfoByAgeLargerThan(int age);
	
	public List<PersonInfo> getPersonInfoByAge(int age);
	
	public List<PersonInfo> getPersonInfoByAgeGreaterThan(int age);
	
	public List<PersonInfo> getPersonInfoByAgeLessThanEqual(int age);
	
	public List<PersonInfo> getPersonInfoByAgeGreaterThanAndCity(int age, String city);
	
	public List<PersonInfo> getPersonInfoByCityContaining(String city);
	
	public List<PersonInfo> getPersonInfoTop2ByCityContaining(String city);
	
}
