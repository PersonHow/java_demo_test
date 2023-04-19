package com.example.java_demo_test.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.example.java_demo_test.entity.Bank;

@Repository
public interface BankDao extends JpaRepository<Bank, String>{
	// JpaRepository < > 中前者放入相對應的 @Entity 類別, 後者放有 @Id 主鍵屬性的資料型態
}
