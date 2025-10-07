package com.coforge.training.onlinebanking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coforge.training.onlinebanking.model.Transaction;

/**
* Author   : Shradhey.Naudiyal
* Date     : Oct 7, 2025
* Time     : 12:07:19 PM
* Project  : online-banking
*/
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

}

