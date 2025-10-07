package com.coforge.training.onlinebanking.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coforge.training.onlinebanking.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	Optional<User> findByEmail(String Email);
}
