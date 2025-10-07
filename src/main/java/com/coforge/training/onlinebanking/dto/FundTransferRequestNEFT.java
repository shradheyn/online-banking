package com.coforge.training.onlinebanking.dto;

import java.math.BigDecimal;

public class FundTransferRequestNEFT {
    private Long fromAccountNumber;
    private String toBeneficiaryAccountNumber;
    private BigDecimal amount;
    private String remarks;

    public FundTransferRequestNEFT() {}

    // getters & setters
    public Long getFromAccountNumber() { return fromAccountNumber; }
    public void setFromAccountNumber(Long fromAccountNumber) { this.fromAccountNumber = fromAccountNumber; }
    public String getToBeneficiaryAccountNumber() { return toBeneficiaryAccountNumber; }
    public void setToBeneficiaryAccountNumber(String toBeneficiaryAccountNumber) { this.toBeneficiaryAccountNumber = toBeneficiaryAccountNumber; }
    public BigDecimal getAmount() { return amount; }
    public void setAmount(BigDecimal amount) { this.amount = amount; }
    public String getRemarks() { return remarks; }
    public void setRemarks(String remarks) { this.remarks = remarks; }
}
