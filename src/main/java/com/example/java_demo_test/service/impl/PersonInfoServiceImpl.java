package com.example.java_demo_test.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.example.java_demo_test.entity.PersonInfo;
import com.example.java_demo_test.repository.PersonInfoDao;
import com.example.java_demo_test.service.ifs.PersonInfoService;
import com.example.java_demo_test.vo.PersonInfoRequestA;
import com.example.java_demo_test.vo.PersonInfoResponse;
import com.example.java_demo_test.vo.PersonInfoRequest;
import com.example.java_demo_test.vo.PersonInfoResponseA;

@Service
public class PersonInfoServiceImpl implements PersonInfoService {

	@Autowired
	private PersonInfoDao personInfoDao;

	@Override
	public PersonInfoResponseA addPersonInfo(PersonInfoRequestA persionInfoAddRequest) {
		String addId = persionInfoAddRequest.getId();
		String addName = persionInfoAddRequest.getName();
		int addAge = persionInfoAddRequest.getAge();
		// StringUtils.hasText => 如果裡面是null,"","  "，回傳false
		// name & id　不能為空
		if (!StringUtils.hasText(addName) || !StringUtils.hasText(addId)) {
			return new PersonInfoResponseA(addId, "格式錯誤");
		}
		if (personInfoDao.existsById(addId)) {
			return new PersonInfoResponseA(addId, "ID重複");
		}
		PersonInfo personInfo = new PersonInfo(addId,addName,addAge);
		personInfoDao.save(personInfo);
		return new PersonInfoResponseA(personInfo.getId(), "資訊創建成功");
	}

	@Override
	public List<PersonInfo> getPersonInfo() {
		return new ArrayList<>(personInfoDao.findAll());

	}

	@Override
	public PersonInfoResponseA getPersonInfoById(String id) {
		String idKey = id;
		if (personInfoDao.existsById(idKey)) {
			Optional<PersonInfo> idop = personInfoDao.findById(idKey);
			PersonInfo idInfo = idop.get();
			return new PersonInfoResponseA(idInfo.getId(),idInfo.getName(),idInfo.getAge());
		}
		return new PersonInfoResponseA(idKey,"無此 ID 相關資料");

	}
//                    ========= 老師教學中 =========			  
//	@Override
	public PersonInfoResponse addPersonInfo(PersonInfoRequest request) {
//		PersonInfo reqInfo = request.getPersonInfo();
////		-------- 單筆資料檢查 --------
//		if (!StringUtils.hasText(reqInfo.getName()) || !StringUtils.hasText(reqInfo.getId())) {
//			return new PersonInfoResponse( "格式錯誤");
//		}
//		if (personInfoDao.existsById(reqInfo.getId())) {
//			return new PersonInfoResponse( "ID重複");
//		}
//		personInfoDao.save(reqInfo);
//      =======================================================
//		-------- 多筆資料檢查 --------
		List<PersonInfo> infoList = request.getPersonInfoList();
		List<PersonInfo> errorInfoList = new ArrayList<>();
		for (PersonInfo infoItem : infoList) { // 利用 foreach 逐一取出檢查
			if (!StringUtils.hasText(infoItem.getName()) || !StringUtils.hasText(infoItem.getId())) {
				return new PersonInfoResponse("格式錯誤");
			}
			if (personInfoDao.existsById(infoItem.getId())) {
				errorInfoList.add(infoItem);
//				return new PersonInfoResponse( infoItem,"ID重複");
			}
//			personInfoDao.save(infoItem);	//逐一儲存較耗能源
		}
		if (!errorInfoList.isEmpty()) {
			return new PersonInfoResponse(errorInfoList, "ID重複");
		}
		personInfoDao.saveAll(infoList);
		return new PersonInfoResponse(infoList, "資訊創建成功");
	}

	@Override
	public List<PersonInfo> getPersonInfoByAgeLargerThan(int age) {
		List <PersonInfo> personList = new ArrayList<>(personInfoDao.findAll());
		List <PersonInfo> ageList = new ArrayList<>();
		for(PersonInfo personItem:personList) {
			if(personItem.getAge() > age) {
				ageList.add(personItem);
			}
		}
		return ageList;
	}
//============== 上課新增 =====================
	@Override
	public List<PersonInfo> getPersonInfoByAge(int age){
		// 找到該 age 相關資料
		List<PersonInfo> result = personInfoDao.findByAge(age);
		return result;
	}
	
	@Override
	public List<PersonInfo> getPersonInfoByAgeGreaterThan(int age){
		// 找到該 age 以上(age < )相關資料
		List<PersonInfo> result = personInfoDao.findByAgeGreaterThan(age);
		return result;
	}
	
	@Override
	public List<PersonInfo> getPersonInfoByAgeLessThanEqual(int age){
		// 找到該 age 以下(含)(age >=)相關資料
		List<PersonInfo> result = personInfoDao.findByAgeLessThanEqual(age);
		return result;
	}
	
	@Override
	public List<PersonInfo> getPersonInfoByAgeGreaterThanAndCity(int age, String city){
		List<PersonInfo> result = personInfoDao.findByAgeGreaterThanAndCity(age, city);
		return result;
	}
	
	@Override
	public List<PersonInfo> getPersonInfoByCityContaining(String city){
//		List<PersonInfo> result = personInfoDao.findByCityContaining(city);
//		List<PersonInfo> result = personInfoDao.findByCityContainingOrderByAge(city);		// 按年齡排序，預設是Asc
//		List<PersonInfo> result = personInfoDao.findByCityContainingOrderByAgeAsc(city);	// 遞增
		List<PersonInfo> result = personInfoDao.findByCityContainingOrderByAgeDesc(city);	// 遞減
		return result;
	}
	
	@Override
	public List<PersonInfo> getPersonInfoTop2ByCityContaining(String city){
	List<PersonInfo> result = personInfoDao.findTop2ByCityContaining(city);
	return result;
	}
}
