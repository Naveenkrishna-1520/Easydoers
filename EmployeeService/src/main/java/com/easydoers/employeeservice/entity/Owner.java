package com.easydoers.employeeservice.entity;

import java.time.LocalDate;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class Owner {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ownerId;
	private String ownerName;
	private Long contact;
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private Address address;
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id", nullable = false)
    private Company company;
	private String updatedPersonName;
    private LocalDate updateTime;
	/**
	 * 
	 */
	public Owner() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param ownerId
	 * @param ownerName
	 * @param contact
	 * @param address
	 * @param company
	 * @param updatedPersonName
	 * @param updateTime
	 */
	public Owner(Long ownerId, String ownerName, Long contact, Address address, Company company,
			String updatedPersonName, LocalDate updateTime) {
		super();
		this.ownerId = ownerId;
		this.ownerName = ownerName;
		this.contact = contact;
		this.address = address;
		this.company = company;
		this.updatedPersonName = updatedPersonName;
		this.updateTime = updateTime;
	}
	/**
	 * @return the ownerId
	 */
	public Long getOwnerId() {
		return ownerId;
	}
	/**
	 * @param ownerId the ownerId to set
	 */
	public void setOwnerId(Long ownerId) {
		this.ownerId = ownerId;
	}
	/**
	 * @return the ownerName
	 */
	public String getOwnerName() {
		return ownerName;
	}
	/**
	 * @param ownerName the ownerName to set
	 */
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	/**
	 * @return the contact
	 */
	public Long getContact() {
		return contact;
	}
	/**
	 * @param contact the contact to set
	 */
	public void setContact(Long contact) {
		this.contact = contact;
	}
	/**
	 * @return the address
	 */
	public Address getAddress() {
		return address;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(Address address) {
		this.address = address;
	}
	/**
	 * @return the company
	 */
	public Company getCompany() {
		return company;
	}
	/**
	 * @param company the company to set
	 */
	public void setCompany(Company company) {
		this.company = company;
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
		return "Owner [ownerId=" + ownerId + ", ownerName=" + ownerName + ", contact=" + contact + ", address="
				+ address + ", company=" + company + ", updatedPersonName=" + updatedPersonName + ", updateTime="
				+ updateTime + "]";
	}
	
	

}
