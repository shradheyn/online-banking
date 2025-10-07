package com.coforge.training.onlinebanking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coforge.training.onlinebanking.model.Account;

public interface AccountUser extends JpaRepository<Account, Long>{

}
