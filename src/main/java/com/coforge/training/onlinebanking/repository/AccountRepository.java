package com.coforge.training.onlinebanking.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coforge.training.onlinebanking.model.Account;

public interface AccountRepository extends JpaRepository<Account, Long>{

	Optional<Account> findByAccountNumber(String accountNumber);

}
