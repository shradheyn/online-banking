package com.coforge.training.onlinebanking.dto;

import java.math.BigDecimal;

public class FundTransferRequestUPI {
    private Long fromAccountNumber;
    private String upiId; // e.g. vpa@bank
    private BigDecimal amount;
    private String remarks;

    public FundTransferRequestUPI() {}

    // getters & setters
    public Long getFromAccountNumber() { return fromAccountNumber; }
    public void setFromAccountNumber(Long fromAccountNumber) { this.fromAccountNumber = fromAccountNumber; }
    public String getUpiId() { return upiId; }
    public void setUpiId(String upiId) { this.upiId = upiId; }
    public BigDecimal getAmount() { return amount; }
    public void setAmount(BigDecimal amount) { this.amount = amount; }
    public String getRemarks() { return remarks; }
    public void setRemarks(String remarks) { this.remarks = remarks; }
}
