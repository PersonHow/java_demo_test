package com.example.java_demo_test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.java_demo_test.entity.PersonInfo;
import com.example.java_demo_test.service.ifs.PersonInfoService;
import com.example.java_demo_test.vo.PersonInfoRequestA;
import com.example.java_demo_test.vo.PersonInfoResponse;
import com.example.java_demo_test.vo.PersonInfoRequest;
import com.example.java_demo_test.vo.PersonInfoResponseA;

@RestController
public class PersonInfoController {
	
	@Autowired
	private PersonInfoService personInfoService;
	
	
	@PostMapping("addPersonInfoA")
	public PersonInfoResponseA addPersonInfo(@RequestBody PersonInfoRequestA personInfoAddRequest) {
		return personInfoService.addPersonInfo(personInfoAddRequest);
	}

	@PostMapping("addPersonInfo")
	public PersonInfoResponse addPersonInfo(@RequestBody PersonInfoRequest request) {
		return personInfoService.addPersonInfo(request);
	}
	
	@RequestMapping(value = "/getPersonInfo", method = RequestMethod.POST)
	public List<PersonInfo> getPersonInfo(){
		return personInfoService.getPersonInfo();
	}
	
	@PostMapping("getPersonInfoById")
	public PersonInfoResponseA getPersonInfoById(@RequestBody PersonInfoRequestA personInfoAddRequest) {
		return personInfoService.getPersonInfoById(personInfoAddRequest.getId());
	}
	
	@RequestMapping(value = "getPersonByAgeLarger", method = RequestMethod.POST)
	public List<PersonInfo> getPersonInfoByAgeLargerThan(@RequestBody PersonInfoRequest request){
		return personInfoService.getPersonInfoByAgeLargerThan(request.getPersonInfo().getAge());
	}
	
	@RequestMapping(value = "getPerson_ByAge", method = RequestMethod.POST)
	public List<PersonInfo> getPersonInfoByAge(@RequestBody PersonInfoRequest request){
		return personInfoService.getPersonInfoByAge(request.getAge());
	}
	
	@RequestMapping(value = "getPerson_ByAge_GreaterThan", method = RequestMethod.POST)
	public List<PersonInfo> getPersonInfoByAgeGreaterThan(@RequestBody PersonInfoRequest request){
		return personInfoService.getPersonInfoByAgeGreaterThan(request.getAge());
	}
	
	@RequestMapping(value = "getPerson_ByAge_LessThanEqual", method = RequestMethod.POST)
	public List<PersonInfo> getPersonInfoByAgeLessThanEqual(@RequestBody PersonInfoRequest request){
		return personInfoService.getPersonInfoByAgeLessThanEqual(request.getAge());
	}
	
	@PostMapping("getPerson_By_AgeGreaterThan_And_City")
	public List<PersonInfo> getPersonInfoByAgeGreaterThanAndCity(@RequestBody PersonInfoRequest request){
		return personInfoService.getPersonInfoByAgeGreaterThanAndCity(request.getAge(), request.getCity());
	}
	
	@PostMapping("getPerson_By_CityContaining")
	public List<PersonInfo> getPersonInfoByCityContaining(@RequestBody PersonInfoRequest request){
		return personInfoService.getPersonInfoByCityContaining(request.getCity());
	}
	
	@PostMapping("getPerson_Top2_By_CityContaining")
	public List<PersonInfo> getPersonInfoTop2ByCityContaining(@RequestBody PersonInfoRequest request){
		return personInfoService.getPersonInfoTop2ByCityContaining(request.getCity());
	}
}
