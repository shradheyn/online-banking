package com.coforge.training.onlinebanking.service;

import com.coforge.training.onlinebanking.exception.ResourceNotFoundException;
import com.coforge.training.onlinebanking.model.Account;
import com.coforge.training.onlinebanking.model.User;
import com.coforge.training.onlinebanking.repository.AccountRepository;
import com.coforge.training.onlinebanking.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class AccountService {

    private final AccountRepository accountRepository;
    private final UserRepository userRepository;

    public AccountService(AccountRepository accountRepository, UserRepository userRepository) {
        this.accountRepository = accountRepository;
        this.userRepository = userRepository;
    }

    public Account create(Account account, Long userId) {
        User u = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User not found: " + userId));
        account.setUser(u);
        if (account.getBalance() == null) account.setBalance(BigDecimal.ZERO);
        return accountRepository.save(account);
    }

    public Account getByAccountNumber(Long accountNumber) {
        return accountRepository.findByAccountNumber(accountNumber)
                .orElseThrow(() -> new ResourceNotFoundException("Account not found: " + accountNumber));
    }

    public List<Account> getByUser(Long userId) {
        User u = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User not found: " + userId));
        return accountRepository.findByUser(u);
    }

    public Account update(Account updated) {
        Account a = getByAccountNumber(updated.getAccountNumber());
        a.setAccountType(updated.getAccountType());
        a.setStatus(updated.getStatus());
        a.setBalance(updated.getBalance());
        return accountRepository.save(a);
    }
}
