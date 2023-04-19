package com.example.java_demo_test.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.java_demo_test.entity.PersonInfo;

@Repository
public interface PersonInfoDao extends JpaRepository<PersonInfo, String> {
//這邊可以前往Spring boot找到關鍵語法自定義方法
	// JPA 的搜尋都是 find...，自訂義方法

	List<PersonInfo> findByAge(int age);				//自訂義 找到該 age 相關資料

	List<PersonInfo> findByAgeGreaterThan(int age);		//自訂義 找到該 age 以上(age < )相關資料

	List<PersonInfo> findByAgeLessThanEqual(int age);	//自訂義 找到該 age 以下(含)(age >=)相關資料
	
	List<PersonInfo> findByAgeGreaterThanAndCity(int age, String city);
	
	List<PersonInfo> findByCityContaining(String city);
	
	List<PersonInfo> findTop2ByCityContaining(String city);
	
	List<PersonInfo> findByCityContainingOrderByAge(String city);
	
	List<PersonInfo> findByCityContainingOrderByAgeAsc(String city);
	
	List<PersonInfo> findByCityContainingOrderByAgeDesc(String city);
}
