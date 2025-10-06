package com.coforge.training.onlinebanking.model;

import java.time.LocalDate;
import jakarta.persistence.*;

@Entity
@Table(name = "payees")
public class Payee {

    // Primary Key
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payee_id")
    private int payee_id;

    // Foreign Key: Many payees can be registered by one user
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "u_id", nullable = false)
    private User user;   // Relationship: User "registers payee"

    @Column(name = "beneficiary_name", nullable = false, length = 100)
    private String beneficiary_name;

    @Column(name = "beneficiary_account_number", nullable = false, unique = true, length = 20)
    private String beneficiary_account_number;

    @Column(name = "nickname", length = 50)
    private String nickname;

    @Column(name = "datetime", nullable = false)
    private LocalDate datetime;

    
}
