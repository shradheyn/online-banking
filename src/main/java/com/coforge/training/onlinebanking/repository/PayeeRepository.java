package com.coforge.training.onlinebanking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coforge.training.onlinebanking.model.Account;
import com.coforge.training.onlinebanking.model.Payee;

/**
* Author   : Shradhey.Naudiyal
* Date     : Oct 7, 2025
* Time     : 12:03:31 PM
* Project  : online-banking
*/
public interface PayeeRepository extends JpaRepository<Payee, Long>{

}
