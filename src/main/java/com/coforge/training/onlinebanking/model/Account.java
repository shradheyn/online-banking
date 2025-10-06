package com.coforge.training.onlinebanking.model;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "accounts")
public class Account {

    // Primary Key (Generated starting from 100245)
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "account_seq")
    @SequenceGenerator(name = "account_seq", initialValue = 100245, allocationSize = 1)
    @Column(name = "account_number")
    private Long account_number;

    // Foreign Key to users table
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "u_id", nullable = false)
    private User user;   // FK reference to User.u_id

    @Column(name = "account_type", nullable = false, length = 50)
    private String account_type;

    @Column(name = "balance", nullable = false)
    private String balance;

    @Column(name = "status", nullable = false, length = 20)
    private String status;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private LocalDateTime created_at;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updated_at;

    // Getters & Setters
}
