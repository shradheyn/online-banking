package com.coforge.training.onlinebanking.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coforge.training.onlinebanking.model.Payee;
import com.coforge.training.onlinebanking.model.User;


/**
* Author   : Shradhey.Naudiyal
* Date     : Oct 7, 2025
* Time     : 12:03:31 PM
* Project  : online-banking
*/
public interface PayeeRepository extends JpaRepository<Payee, Long>{
	List<Payee> findByUser(User user);
    Optional<Payee> findByBeneficiaryAccountNumber(String accountNumber);
}
