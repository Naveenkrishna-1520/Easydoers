package com.easydoers.employeeservice.dto;

public class ClockinRequest {
	
	private String employeeNtid;
	private String dealerStoreId;
	/**
	 * 
	 */
	public ClockinRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param employeeNtid
	 * @param dealerStoreId
	 */
	public ClockinRequest(String employeeNtid, String dealerStoreId) {
		super();
		this.employeeNtid = employeeNtid;
		this.dealerStoreId = dealerStoreId;
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
	 * @return the dealerStoreId
	 */
	public String getDealerStoreId() {
		return dealerStoreId;
	}
	/**
	 * @param dealerStoreId the dealerStoreId to set
	 */
	public void setDealerStoreId(String dealerStoreId) {
		this.dealerStoreId = dealerStoreId;
	}
	
}
