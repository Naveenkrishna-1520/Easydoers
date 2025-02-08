package com.easydoers.employeeservice.entity;

import java.time.LocalDateTime;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity

public class Company {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int companyId;
	private String companyName;
	private String email;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private Address CompanyAddress;
    private String updatedPerson;
    private LocalDateTime updateTime;
	/**
	 * 
	 */
	public Company() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param companyId
	 * @param companyName
	 * @param email
	 * @param companyAddress
	 * @param updatedPerson
	 * @param updateTime
	 */
	public Company(int companyId, String companyName, String email, Address companyAddress, String updatedPerson,
			LocalDateTime updateTime) {
		super();
		this.companyId = companyId;
		this.companyName = companyName;
		this.email = email;
		CompanyAddress = companyAddress;
		this.updatedPerson = updatedPerson;
		this.updateTime = updateTime;
	}
	/**
	 * @return the companyId
	 */
	public int getCompanyId() {
		return companyId;
	}
	/**
	 * @param companyId the companyId to set
	 */
	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}
	/**
	 * @return the companyName
	 */
	public String getCompanyName() {
		return companyName;
	}
	/**
	 * @param companyName the companyName to set
	 */
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
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
	 * @return the companyAddress
	 */
	public Address getCompanyAddress() {
		return CompanyAddress;
	}
	/**
	 * @param companyAddress the companyAddress to set
	 */
	public void setCompanyAddress(Address companyAddress) {
		CompanyAddress = companyAddress;
	}
	/**
	 * @return the updatedPerson
	 */
	public String getUpdatedPerson() {
		return updatedPerson;
	}
	/**
	 * @param updatedPerson the updatedPerson to set
	 */
	public void setUpdatedPerson(String updatedPerson) {
		this.updatedPerson = updatedPerson;
	}
	/**
	 * @return the updateTime
	 */
	public LocalDateTime getUpdateTime() {
		return updateTime;
	}
	/**
	 * @param updateTime the updateTime to set
	 */
	public void setUpdateTime(LocalDateTime updateTime) {
		this.updateTime = updateTime;
	}
	
}