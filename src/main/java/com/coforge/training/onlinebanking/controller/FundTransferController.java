package com.coforge.training.onlinebanking.controller;

import com.coforge.training.onlinebanking.dto.FundTransferRequestNEFT;
import com.coforge.training.onlinebanking.dto.FundTransferRequestUPI;
import com.coforge.training.onlinebanking.model.Transaction;
import com.coforge.training.onlinebanking.service.FundTransferService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/fund-transfer")
public class FundTransferController {
    private final FundTransferService service;
    public FundTransferController(FundTransferService service) { this.service = service; }

    @PostMapping("/neft")
    public ResponseEntity<Transaction> neft(@RequestBody FundTransferRequestNEFT req) {
        Transaction t = service.transferNEFT(req);
        return ResponseEntity.ok(t);
    }

    @PostMapping("/upi")
    public ResponseEntity<Transaction> upi(@RequestBody FundTransferRequestUPI req) {
        Transaction t = service.transferUPI(req);
        return ResponseEntity.ok(t);
    }
}
