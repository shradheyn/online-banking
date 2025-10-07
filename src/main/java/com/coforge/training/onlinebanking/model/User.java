package com.coforge.training.onlinebanking.model;


import java.sql.Date;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;


@Entity
@Table(name="users")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "dealer_seq")
	@SequenceGenerator(name="dealer_seq", initialValue = 101, allocationSize = 1)
	@Column(name="u_id")
	private long user_id;

	@Column(name="first_name", nullable=false)
	private String f_name;

	@Column(name="last_name", nullable=false)
	private String l_name;

	@JsonFormat(pattern="yyyy-MM-dd")
	@Column(nullable=false)
	private Date dob;

	@Column(unique=true, nullable=false)
	private String email;

	@Column(name="phone_no", unique=true, nullable=false)
	private String phone_number;

	@Column(unique=true, nullable=false)
	private String aadhar_number;

	@Column(name="residential_address", nullable=false)
	private String residential_address;

	@Column(name="permanent_address")
	private String permanent_address;

	@Column(name="occupation")
	private String occupation;

	@CreationTimestamp
	@Column(name="created_at", updatable=false)
	private LocalDateTime created_at;

	@UpdateTimestamp
	@Column(name="updated_at")
	private LocalDateTime updated_at;

	
}
