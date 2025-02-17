package com.easydoers.employeeservice.dto;

public class ManagerDetailsDTO {
	
	private Long managerId;
	private String managerNtid;
	private String managerName;
	private String gender;
	private Long contact;
	private String email;
	/**
	 * 
	 */
	public ManagerDetailsDTO() {
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
	 */
	public ManagerDetailsDTO(Long managerId, String managerNtid, String managerName, String gender, Long contact,
			String email) {
		super();
		this.managerId = managerId;
		this.managerNtid = managerNtid;
		this.managerName = managerName;
		this.gender = gender;
		this.contact = contact;
		this.email = email;
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
	
	

}
