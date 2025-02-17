package com.easydoers.employeeservice.dto;

public class EmployeeDTO {
	
	private String employeeNtid;
	private String employeeName;
	
	
	/**
	 * @param employeeNtid
	 * @param employeeName
	 */
	public EmployeeDTO(String employeeNtid, String employeeName) {
		super();
		this.employeeNtid = employeeNtid;
		this.employeeName = employeeName;
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
	@Override
	public String toString() {
		return "[employeeNtid=" + employeeNtid + ", employeeName=" + employeeName + "]";
	}
	
	

}
