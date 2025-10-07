package com.coforge.training.onlinebanking.service;

import com.coforge.training.onlinebanking.dto.FundTransferRequestNEFT;
import com.coforge.training.onlinebanking.dto.FundTransferRequestUPI;
import com.coforge.training.onlinebanking.exception.BadRequestException;
import com.coforge.training.onlinebanking.exception.InsufficientFundsException;
import com.coforge.training.onlinebanking.exception.ResourceNotFoundException;
import com.coforge.training.onlinebanking.model.Account;
import com.coforge.training.onlinebanking.model.Payee;
import com.coforge.training.onlinebanking.model.Transaction;
import com.coforge.training.onlinebanking.repository.AccountRepository;
import com.coforge.training.onlinebanking.repository.PayeeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class FundTransferService {

    private final AccountRepository accountRepository;
    private final PayeeRepository payeeRepository;
    private final TransactionService transactionService;

    public FundTransferService(AccountRepository accountRepository, PayeeRepository payeeRepository, TransactionService transactionService) {
        this.accountRepository = accountRepository;
        this.payeeRepository = payeeRepository;
        this.transactionService = transactionService;
    }

    @Transactional
    public Transaction transferNEFT(FundTransferRequestNEFT req) {
        if (req.getAmount() == null || req.getAmount().compareTo(BigDecimal.ZERO) <= 0) {
            throw new BadRequestException("Amount must be positive");
        }

        Long fromAccNum = req.getFromAccountNumber();
        Account from = accountRepository.findByAccountNumber(fromAccNum)
                .orElseThrow(() -> new ResourceNotFoundException("From account not found: " + fromAccNum));

        Optional<Payee> maybePayee = payeeRepository.findByBeneficiaryAccountNumber(req.getToBeneficiaryAccountNumber());
        if (maybePayee.isEmpty()) {
            // if payee not found, still allow transfer? Business choice — we block unless payee exists
            throw new BadRequestException("Beneficiary not registered as payee");
        }

        if (from.getBalance().compareTo(req.getAmount()) < 0) {
            throw new InsufficientFundsException("Insufficient balance");
        }

        // Debit
        from.setBalance(from.getBalance().subtract(req.getAmount()));
        accountRepository.save(from);

        // Credit: find beneficiary account in system (if exists)
        Optional<Account> beneficiaryAccount = accountRepository.findAll().stream()
                .filter(a -> a.getAccountNumber() != null)
                .filter(a -> a.getAccountNumber().toString().equals(req.getToBeneficiaryAccountNumber()))
                .findFirst();

        if (beneficiaryAccount.isPresent()) {
            Account ben = beneficiaryAccount.get();
            ben.setBalance(ben.getBalance().add(req.getAmount()));
            accountRepository.save(ben);
        }
        // Create Transaction record
        Transaction t = new Transaction();
        t.setAccount(from);
        t.setBeneficiaryAccountNumber(req.getToBeneficiaryAccountNumber());
        t.setAmount(req.getAmount());
        t.setMode("NEFT");
        t.setStatus("SUCCESS");
        t.setTransactionTime(LocalDateTime.now());
        t.setRemarks(req.getRemarks());
        return transactionService.save(t);
    }

    @Transactional
    public Transaction transferUPI(FundTransferRequestUPI req) {
        if (req.getAmount() == null || req.getAmount().compareTo(BigDecimal.ZERO) <= 0) {
            throw new BadRequestException("Amount must be positive");
        }

        Long fromAccNum = req.getFromAccountNumber();
        Account from = accountRepository.findByAccountNumber(fromAccNum)
                .orElseThrow(() -> new ResourceNotFoundException("From account not found: " + fromAccNum));

        // Simplified UPI: we will not resolve external UPI IDs; require beneficiary to be registered as payee with upiId (stored in nickname or beneficiaryAccountNumber field)
        // For demo: check payee repository where beneficiaryAccountNumber equals provided upiId
        Optional<Payee> maybePayee = payeeRepository.findByBeneficiaryAccountNumber(req.getUpiId());
        if (maybePayee.isEmpty()) {
            throw new BadRequestException("UPI beneficiary not registered");
        }

        if (from.getBalance().compareTo(req.getAmount()) < 0) {
            throw new InsufficientFundsException("Insufficient balance");
        }

        from.setBalance(from.getBalance().subtract(req.getAmount()));
        accountRepository.save(from);

        // If there's an internal account mapped, credit it (best-effort)
        Optional<Account> beneficiaryAccount = accountRepository.findAll().stream()
                .filter(a -> a.getUser() != null)
                .filter(a -> a.getUser().getEmail() != null) // dummy filter just to iterate
                .filter(a -> a.getAccountNumber() != null && a.getAccountNumber().toString().equals(req.getUpiId()))
                .findFirst();

        if (beneficiaryAccount.isPresent()) {
            Account ben = beneficiaryAccount.get();
            ben.setBalance(ben.getBalance().add(req.getAmount()));
            accountRepository.save(ben);
        }

        Transaction t = new Transaction();
        t.setAccount(from);
        t.setBeneficiaryAccountNumber(req.getUpiId());
        t.setAmount(req.getAmount());
        t.setMode("UPI");
        t.setStatus("SUCCESS");
        t.setTransactionTime(LocalDateTime.now());
        t.setRemarks(req.getRemarks());
        return transactionService.save(t);
    }
}
