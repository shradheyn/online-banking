package com.coforge.training.onlinebanking.service;

import com.coforge.training.onlinebanking.exception.ResourceNotFoundException;
import com.coforge.training.onlinebanking.model.Payee;
import com.coforge.training.onlinebanking.model.User;
import com.coforge.training.onlinebanking.repository.PayeeRepository;
import com.coforge.training.onlinebanking.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PayeeService {
    private final PayeeRepository payeeRepository;
    private final UserRepository userRepository;

    public PayeeService(PayeeRepository payeeRepository, UserRepository userRepository) {
        this.payeeRepository = payeeRepository;
        this.userRepository = userRepository;
    }

    public Payee addPayee(Long userId, Payee p) {
        User u = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User not found: " + userId));
        p.setUser(u);
        return payeeRepository.save(p);
    }

    public List<Payee> listByUser(Long userId) {
        User u = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User not found: " + userId));
        return payeeRepository.findByUser(u);
    }

    public void remove(Long payeeId) {
        payeeRepository.delete(payeeRepository.findById(payeeId).orElseThrow(() -> new ResourceNotFoundException("Payee not found: " + payeeId)));
    }
}
