package com.coforge.training.onlinebanking.service;

import com.coforge.training.onlinebanking.model.Transaction;
import com.coforge.training.onlinebanking.model.Account;
import com.coforge.training.onlinebanking.repository.TransactionRepository;
import com.coforge.training.onlinebanking.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {
    private final TransactionRepository transactionRepository;
    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public Transaction save(Transaction t) { return transactionRepository.save(t); }

    public List<Transaction> findByAccount(Account account) {
        return transactionRepository.findByAccount(account);
    }

    public Transaction getById(Long id) {
        return transactionRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Transaction not found: " + id));
    }
}
