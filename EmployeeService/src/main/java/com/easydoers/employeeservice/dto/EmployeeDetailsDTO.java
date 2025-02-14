package com.easydoers.employeeservice.dto;



public class EmployeeDetailsDTO {
	
	private Long employeeId;
	private String employeeNtid;
	private String employeeName;
	private Long phoneNumber;
	private String email;
	private int employeePayRatePerHour;
	private int commissionPercentage;
	private int perBoxCommission;
	/**
	 * 
	 */
	public EmployeeDetailsDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param employeeId
	 * @param employeeNtid
	 * @param employeeName
	 * @param phoneNumber
	 * @param email
	 * @param employeePayRatePerHour
	 * @param commissionPercentage
	 * @param perBoxCommission
	 */
	public EmployeeDetailsDTO(Long employeeId, String employeeNtid, String employeeName, Long phoneNumber, String email,
			int employeePayRatePerHour, int commissionPercentage, int perBoxCommission) {
		super();
		this.employeeId = employeeId;
		this.employeeNtid = employeeNtid;
		this.employeeName = employeeName;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.employeePayRatePerHour = employeePayRatePerHour;
		this.commissionPercentage = commissionPercentage;
		this.perBoxCommission = perBoxCommission;
	}
	/**
	 * @return the employeeId
	 */
	public Long getEmployeeId() {
		return employeeId;
	}
	/**
	 * @param employeeId the employeeId to set
	 */
	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}
	/**
	 * @return the employeeNtid
	 */
	public String getEmployeeNtid() {
		return employeeNtid;
	}
	/**
	 * @param employeeNtid the employeeNtid to set
	 */
	public void setEmployeeNtid(String employeeNtid) {
		this.employeeNtid = employeeNtid;
	}
	/**
	 * @return the employeeName
	 */
	public String getEmployeeName() {
		return employeeName;
	}
	/**
	 * @param employeeName the employeeName to set
	 */
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	/**
	 * @return the phoneNumber
	 */
	public Long getPhoneNumber() {
		return phoneNumber;
	}
	/**
	 * @param phoneNumber the phoneNumber to set
	 */
	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
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
	 * @return the employeePayRatePerHour
	 */
	public int getEmployeePayRatePerHour() {
		return employeePayRatePerHour;
	}
	/**
	 * @param employeePayRatePerHour the employeePayRatePerHour to set
	 */
	public void setEmployeePayRatePerHour(int employeePayRatePerHour) {
		this.employeePayRatePerHour = employeePayRatePerHour;
	}
	/**
	 * @return the commissionPercentage
	 */
	public int getCommissionPercentage() {
		return commissionPercentage;
	}
	/**
	 * @param commissionPercentage the commissionPercentage to set
	 */
	public void setCommissionPercentage(int commissionPercentage) {
		this.commissionPercentage = commissionPercentage;
	}
	/**
	 * @return the perBoxCommission
	 */
	public int getPerBoxCommission() {
		return perBoxCommission;
	}
	/**
	 * @param perBoxCommission the perBoxCommission to set
	 */
	public void setPerBoxCommission(int perBoxCommission) {
		this.perBoxCommission = perBoxCommission;
	}

}
