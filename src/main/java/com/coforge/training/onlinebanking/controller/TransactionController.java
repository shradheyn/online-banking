package com.coforge.training.onlinebanking.controller;

import com.coforge.training.onlinebanking.model.Transaction;
import com.coforge.training.onlinebanking.model.Account;
import com.coforge.training.onlinebanking.service.AccountService;
import com.coforge.training.onlinebanking.service.TransactionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {
    private final TransactionService transactionService;
    private final AccountService accountService;

    public TransactionController(TransactionService transactionService, AccountService accountService) {
        this.transactionService = transactionService;
        this.accountService = accountService;
    }

    @GetMapping("/account/{accountNumber}")
    public ResponseEntity<List<Transaction>> byAccount(@PathVariable Long accountNumber) {
        Account a = accountService.getByAccountNumber(accountNumber);
        return ResponseEntity.ok(transactionService.findByAccount(a));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Transaction> byId(@PathVariable Long id) {
        return ResponseEntity.ok(transactionService.getById(id));
    }
}
