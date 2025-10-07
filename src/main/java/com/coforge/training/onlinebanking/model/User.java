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

	/**
	 * 
	 */
	public User() {
		super();
	}

	/**
	 * @param user_id
	 * @param f_name
	 * @param l_name
	 * @param dob
	 * @param email
	 * @param phone_number
	 * @param aadhar_number
	 * @param residential_address
	 * @param permanent_address
	 * @param occupation
	 * @param created_at
	 * @param updated_at
	 */
	public User(long user_id, String f_name, String l_name, Date dob, String email, String phone_number,
			String aadhar_number, String residential_address, String permanent_address, String occupation,
			LocalDateTime created_at, LocalDateTime updated_at) {
		super();
		this.user_id = user_id;
		this.f_name = f_name;
		this.l_name = l_name;
		this.dob = dob;
		this.email = email;
		this.phone_number = phone_number;
		this.aadhar_number = aadhar_number;
		this.residential_address = residential_address;
		this.permanent_address = permanent_address;
		this.occupation = occupation;
		this.created_at = created_at;
		this.updated_at = updated_at;
	}

	/**
	 * @return the user_id
	 */
	public long getUser_id() {
		return user_id;
	}

	/**
	 * @param user_id the user_id to set
	 */
	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}

	/**
	 * @return the f_name
	 */
	public String getF_name() {
		return f_name;
	}

	/**
	 * @param f_name the f_name to set
	 */
	public void setF_name(String f_name) {
		this.f_name = f_name;
	}

	/**
	 * @return the l_name
	 */
	public String getL_name() {
		return l_name;
	}

	/**
	 * @param l_name the l_name to set
	 */
	public void setL_name(String l_name) {
		this.l_name = l_name;
	}

	/**
	 * @return the dob
	 */
	public Date getDob() {
		return dob;
	}

	/**
	 * @param dob the dob to set
	 */
	public void setDob(Date dob) {
		this.dob = dob;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the phone_number
	 */
	public String getPhone_number() {
		return phone_number;
	}

	/**
	 * @param phone_number the phone_number to set
	 */
	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	/**
	 * @return the aadhar_number
	 */
	public String getAadhar_number() {
		return aadhar_number;
	}

	/**
	 * @param aadhar_number the aadhar_number to set
	 */
	public void setAadhar_number(String aadhar_number) {
		this.aadhar_number = aadhar_number;
	}

	/**
	 * @return the residential_address
	 */
	public String getResidential_address() {
		return residential_address;
	}

	/**
	 * @param residential_address the residential_address to set
	 */
	public void setResidential_address(String residential_address) {
		this.residential_address = residential_address;
	}

	/**
	 * @return the permanent_address
	 */
	public String getPermanent_address() {
		return permanent_address;
	}

	/**
	 * @param permanent_address the permanent_address to set
	 */
	public void setPermanent_address(String permanent_address) {
		this.permanent_address = permanent_address;
	}

	/**
	 * @return the occupation
	 */
	public String getOccupation() {
		return occupation;
	}

	/**
	 * @param occupation the occupation to set
	 */
	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	/**
	 * @return the created_at
	 */
	public LocalDateTime getCreated_at() {
		return created_at;
	}

	/**
	 * @param created_at the created_at to set
	 */
	public void setCreated_at(LocalDateTime created_at) {
		this.created_at = created_at;
	}

	/**
	 * @return the updated_at
	 */
	public LocalDateTime getUpdated_at() {
		return updated_at;
	}

	/**
	 * @param updated_at the updated_at to set
	 */
	public void setUpdated_at(LocalDateTime updated_at) {
		this.updated_at = updated_at;
	}
	
	

	
}
