package com.example.java_demo_test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import com.example.java_demo_test.entity.PersonInfo;
import com.example.java_demo_test.repository.PersonInfoDao;

@SpringBootTest(classes = JavaDemoTestApplication.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS) // 用於 @BeforeAll & @AfterAll
public class PersonInfoTest {
	private List<PersonInfo> personList;
	@Autowired
	private PersonInfoDao personInfoDao;
	
	@Test
	public void findByAgeTest() {
//		有 Each 兄弟，新增與刪除資料放在他們那就行
//		PersonInfo personInfo = new PersonInfo("testA","AAA",66,"桃園");
//		// 新增一筆假資料
//		personInfoDao.save(personInfo);
		
		// 測試 findByAge 功能
		List<PersonInfo> result = personInfoDao.findByAge(66);
		// 驗證結果是否正確
		Assert.isTrue(result.size() == 1, "測試爆炸");
		
		
//		// 測試完沒問題刪除假資料
//		personInfoDao.delete(personInfo);
	}
	
	@Test
	public void findByAgeGreaterThanTest() {
//		有 Each 兄弟，新增與刪除資料放在他們那就行
//		PersonInfo personInfo = new PersonInfo("testA","A",66,"桃園");
//		PersonInfo personInfo1 = new PersonInfo("testB","B",70,"新竹");
//		PersonInfo personInfo2 = new PersonInfo("testC","A",72,"苗栗");
//		List <PersonInfo> personList = Arrays.asList(personInfo,personInfo1,personInfo2);
//		personInfoDao.saveAll(personList);
		
		
		// 測試功能
		List<PersonInfo> test = personInfoDao.findByAgeGreaterThan(59);
		Assert.isTrue(test.size() == 4, "測試爆炸");
		
		
//		personInfoDao.deleteAll(personList);
	}
	
	@BeforeEach
	public void beforeTest() {
		System.out.println("=========BeforeEach");
//		PersonInfo personInfo = new PersonInfo("testA","A",66,"桃園");
//		PersonInfo personInfo1 = new PersonInfo("testB","B",70,"新竹");
//		PersonInfo personInfo2 = new PersonInfo("testC","A",72,"苗栗");
//		personList = Arrays.asList(personInfo,personInfo1,personInfo2);
//		personInfoDao.saveAll(personList);
	}
	
	@AfterEach
	public void afterTest() {
		System.out.println("=========AfterEach");
//		personInfoDao.deleteAll(personList);
	}
	
	@BeforeAll
	public void beforeAllTest() {
		System.out.println("=========BeforeEach");
		PersonInfo personInfo = new PersonInfo("testA","A",66,"桃園");
		PersonInfo personInfo1 = new PersonInfo("testB","B",70,"新竹");
		PersonInfo personInfo2 = new PersonInfo("testC","A",72,"苗栗");
		personList = Arrays.asList(personInfo,personInfo1,personInfo2);
		personInfoDao.saveAll(personList);
	}
	
	@AfterAll
	public void afterAllTest() {
		System.out.println("=========AfterEach");
		personInfoDao.deleteAll(personList);
	}
}
