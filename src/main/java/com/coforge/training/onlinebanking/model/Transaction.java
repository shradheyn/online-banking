package com.coforge.training.onlinebanking.model;

import java.time.LocalDate;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "transactions")
public class Transaction {

    // Primary Key
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transactiosn_id")
    private int transaction_id;

    // Foreign Key: Many transactions belong to one account
    @ManyToOne
    @JoinColumn(name = "account_id", referencedColumnName = "account_number", nullable = false)
    private Account account;   // Relationship: Account "performs transactions"

    @Column(name = "beneficiary_account_number", nullable = false, length = 20)
    private String beneficiary_account_number;

    @Column(name = "mode", nullable = false, length = 20)
    private String mode;

    @Column(name = "amount", nullable = false)
    private double amount;

    @Column(name = "transaction_time", nullable = false)
    private LocalDate transaction_time;

    @Column(name = "status", nullable = false, length = 20)
    private String status;

    // Getters & Setters
}
