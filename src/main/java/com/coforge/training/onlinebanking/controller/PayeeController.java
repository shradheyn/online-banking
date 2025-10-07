package com.coforge.training.onlinebanking.controller;

import com.coforge.training.onlinebanking.model.Payee;
import com.coforge.training.onlinebanking.service.PayeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/payees")
public class PayeeController {
    private final PayeeService service;
    public PayeeController(PayeeService service) { this.service = service; }

    @PostMapping("/user/{userId}")
    public ResponseEntity<Payee> add(@PathVariable Long userId, @RequestBody Payee payee) {
        return ResponseEntity.ok(service.addPayee(userId, payee));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Payee>> list(@PathVariable Long userId) {
        return ResponseEntity.ok(service.listByUser(userId));
    }

    @DeleteMapping("/{payeeId}")
    public ResponseEntity<?> delete(@PathVariable Long payeeId) {
        service.remove(payeeId);
        return ResponseEntity.noContent().build();
    }
}
