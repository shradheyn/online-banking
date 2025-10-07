package com.coforge.training.onlinebanking.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coforge.training.onlinebanking.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
