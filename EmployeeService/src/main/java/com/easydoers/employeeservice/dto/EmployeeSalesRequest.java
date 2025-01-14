package com.easydoers.employeeservice.dto;

public class EmployeeSalesRequest {
	
	private String employeeNtid;

	/**
	 * 
	 */
	public EmployeeSalesRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param employeeNtid
	 */
	public EmployeeSalesRequest(String employeeNtid) {
		super();
		this.employeeNtid = employeeNtid;
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
	
	

}
