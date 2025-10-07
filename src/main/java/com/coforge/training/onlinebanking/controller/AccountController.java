package com.coforge.training.onlinebanking.controller;

import com.coforge.training.onlinebanking.model.Account;
import com.coforge.training.onlinebanking.service.AccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {
    private final AccountService service;
    public AccountController(AccountService service) { this.service = service; }

    @PostMapping("/user/{userId}")
    public ResponseEntity<Account> create(@PathVariable Long userId, @RequestBody Account account) {
        return ResponseEntity.ok(service.create(account, userId));
    }

    @GetMapping("/{accountNumber}")
    public ResponseEntity<Account> get(@PathVariable Long accountNumber) {
        return ResponseEntity.ok(service.getByAccountNumber(accountNumber));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Account>> listByUser(@PathVariable Long userId) {
        return ResponseEntity.ok(service.getByUser(userId));
    }

    @PutMapping
    public ResponseEntity<Account> update(@RequestBody Account account) {
        return ResponseEntity.ok(service.update(account));
    }
}
