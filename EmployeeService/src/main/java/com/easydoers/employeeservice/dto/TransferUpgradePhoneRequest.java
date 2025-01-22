package com.easydoers.employeeservice.dto;

public class TransferUpgradePhoneRequest {
	
	private String employeeNtid;
	private String dealerStoreId;
	private String imei;
	/**
	 * 
	 */
	public TransferUpgradePhoneRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param employeeNtid
	 * @param dealerStoreId
	 * @param imei
	 */
	public TransferUpgradePhoneRequest(String employeeNtid, String dealerStoreId, String imei) {
		super();
		this.employeeNtid = employeeNtid;
		this.dealerStoreId = dealerStoreId;
		this.imei = imei;
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
	/**
	 * @return the imei
	 */
	public String getImei() {
		return imei;
	}
	/**
	 * @param imei the imei to set
	 */
	public void setImei(String imei) {
		this.imei = imei;
	}
	
}
