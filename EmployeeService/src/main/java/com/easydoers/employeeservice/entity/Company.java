package com.easydoers.employeeservice.entity;

import java.time.LocalDate;
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
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private Address CompanyAddress;
    private String updatedPersonName;
    private LocalDate updateTime;
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
	 * @param companyAddress
	 * @param updatedPersonName
	 * @param updateTime
	 */
	public Company(int companyId, String companyName, Address companyAddress, String updatedPersonName,
			LocalDate updateTime) {
		super();
		this.companyId = companyId;
		this.companyName = companyName;
		CompanyAddress = companyAddress;
		this.updatedPersonName = updatedPersonName;
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
	 * @return the updatedPersonName
	 */
	public String getUpdatedPersonName() {
		return updatedPersonName;
	}
	/**
	 * @param updatedPersonName the updatedPersonName to set
	 */
	public void setUpdatedPersonName(String updatedPersonName) {
		this.updatedPersonName = updatedPersonName;
	}
	/**
	 * @return the updateTime
	 */
	public LocalDate getUpdateTime() {
		return updateTime;
	}
	/**
	 * @param updateTime the updateTime to set
	 */
	public void setUpdateTime(LocalDate updateTime) {
		this.updateTime = updateTime;
	}
	@Override
	public String toString() {
		return "Company [companyId=" + companyId + ", companyName=" + companyName + ", CompanyAddress=" + CompanyAddress
				+ ", updatedPersonName=" + updatedPersonName + ", updateTime=" + updateTime + "]";
	}
	
	
	
}