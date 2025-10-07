package com.coforge.training.onlinebanking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coforge.training.onlinebanking.model.Account;
import com.coforge.training.onlinebanking.model.Transaction;

/**
* Author   : Shradhey.Naudiyal
* Date     : Oct 7, 2025
* Time     : 12:07:19 PM
* Project  : online-banking
*/
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
	List<Transaction> findByAccount(Account account);
}

