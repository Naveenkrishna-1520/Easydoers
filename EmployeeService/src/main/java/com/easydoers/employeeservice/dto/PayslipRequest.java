package com.easydoers.employeeservice.dto;


public class PayslipRequest {
	
	private String employeeNtid;
	private String startDate; 
	private String endDate;
	/**
	 * 
	 */
	public PayslipRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param employeeNtid
	 * @param startDate
	 * @param endDate
	 */
	public PayslipRequest(String employeeNtid, String startDate, String endDate) {
		super();
		this.employeeNtid = employeeNtid;
		this.startDate = startDate;
		this.endDate = endDate;
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
	 * @return the startDate
	 */
	public String getStartDate() {
		return startDate;
	}
	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	/**
	 * @return the endDate
	 */
	public String getEndDate() {
		return endDate;
	}
	/**
	 * @param endDate the endDate to set
	 */
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
}
