package com.coforge.training.onlinebanking.repository;

import com.coforge.training.onlinebanking.model.Account;
import com.coforge.training.onlinebanking.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Long> {

    // Find all accounts belonging to a given user
    List<Account> findByUser(User user);

    // Find a single account by its number
    Optional<Account> findByAccountNumber(Long accountNumber);
}
