package com.easydoers.employeeservice.entity;


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
public class Manager {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long managerId;
	private String managerNtid;
	private String managerName;
	private String gender;
	private Long contact;
	private String email;
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id", nullable = false)
    private Company company;
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private Address address;
	/**
	 * 
	 */
	public Manager() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param managerId
	 * @param managerNtid
	 * @param managerName
	 * @param gender
	 * @param contact
	 * @param email
	 * @param company
	 * @param address
	 */
	public Manager(Long managerId, String managerNtid, String managerName, String gender, Long contact, String email,
			Company company, Address address) {
		super();
		this.managerId = managerId;
		this.managerNtid = managerNtid;
		this.managerName = managerName;
		this.gender = gender;
		this.contact = contact;
		this.email = email;
		this.company = company;
		this.address = address;
	}
	/**
	 * @return the managerId
	 */
	public Long getManagerId() {
		return managerId;
	}
	/**
	 * @param managerId the managerId to set
	 */
	public void setManagerId(Long managerId) {
		this.managerId = managerId;
	}
	/**
	 * @return the managerNtid
	 */
	public String getManagerNtid() {
		return managerNtid;
	}
	/**
	 * @param managerNtid the managerNtid to set
	 */
	public void setManagerNtid(String managerNtid) {
		this.managerNtid = managerNtid;
	}
	/**
	 * @return the managerName
	 */
	public String getManagerName() {
		return managerName;
	}
	/**
	 * @param managerName the managerName to set
	 */
	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}
	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}
	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
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
	
	
	
}
