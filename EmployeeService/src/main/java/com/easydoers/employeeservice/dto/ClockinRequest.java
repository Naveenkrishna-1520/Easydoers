package com.easydoers.employeeservice.dto;

public class ClockinRequest {
	
	private String employeeNtid;
	private String delaerStoreId;
	/**
	 * 
	 */
	public ClockinRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param employeeNtid
	 * @param delaerStoreId
	 */
	public ClockinRequest(String employeeNtid, String delaerStoreId) {
		super();
		this.employeeNtid = employeeNtid;
		this.delaerStoreId = delaerStoreId;
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
	 * @return the delaerStoreId
	 */
	public String getDelaerStoreId() {
		return delaerStoreId;
	}
	/**
	 * @param delaerStoreId the delaerStoreId to set
	 */
	public void setDelaerStoreId(String delaerStoreId) {
		this.delaerStoreId = delaerStoreId;
	}
	
	

}
