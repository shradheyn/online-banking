package com.coforge.training.onlinebanking.model;

import java.sql.Date;
import java.time.LocalDateTime;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "dealer_seq")
    @SequenceGenerator(name="dealer_seq", sequenceName = "dealer_seq", initialValue = 101, allocationSize = 1)
    @Column(name="u_id")
    private Long userId;

//    @Column(name="first_name", nullable=false)
    private String fName;

//    @Column(name="last_name", nullable=false)
    private String lName;

    @Column(nullable=false)
    private Date dob;

    @Column(unique=true, nullable=false)
    private String email;

    @Column(name="phone_no", unique=true, nullable=false)
    private String phoneNumber;

    @Column(unique=true, nullable=false)
    private String aadharNumber;

    @Column(name="residential_address", nullable=false)
    private String residentialAddress;

    @Column(name="permanent_address")
    private String permanentAddress;

    @Column(name="occupation")
    private String occupation;

    @CreationTimestamp
    @Column(name="created_at", updatable=false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name="updated_at")
    private LocalDateTime updatedAt;

    public User() {}

    // Getters & setters (omitted here for brevity — include them in actual file)
    // ... include all getters/setters similar to your provided class but with these field names
    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }
    public String getFName() { return fName; }
    public void setFName(String fName) { this.fName = fName; }
    public String getLName() { return lName; }
    public void setLName(String lName) { this.lName = lName; }
    public Date getDob() { return dob; }
    public void setDob(Date dob) { this.dob = dob; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
    public String getAadharNumber() { return aadharNumber; }
    public void setAadharNumber(String aadharNumber) { this.aadharNumber = aadharNumber; }
    public String getResidentialAddress() { return residentialAddress; }
    public void setResidentialAddress(String residentialAddress) { this.residentialAddress = residentialAddress; }
    public String getPermanentAddress() { return permanentAddress; }
    public void setPermanentAddress(String permanentAddress) { this.permanentAddress = permanentAddress; }
    public String getOccupation() { return occupation; }
    public void setOccupation(String occupation) { this.occupation = occupation; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
    public LocalDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(LocalDateTime updatedAt) { this.updatedAt = updatedAt; }
}
