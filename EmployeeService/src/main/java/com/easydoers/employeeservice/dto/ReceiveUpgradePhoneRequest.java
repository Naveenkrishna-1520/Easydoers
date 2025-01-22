package com.easydoers.employeeservice.dto;

public class ReceiveUpgradePhoneRequest {
	
	private String dealerStoreId;
	private String employeeNtid;
	private String imei;
	/**
	 * 
	 */
	public ReceiveUpgradePhoneRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param dealerStoreId
	 * @param employeeNtid
	 * @param imei
	 */
	public ReceiveUpgradePhoneRequest(String dealerStoreId, String employeeNtid, String imei) {
		super();
		this.dealerStoreId = dealerStoreId;
		this.employeeNtid = employeeNtid;
		this.imei = imei;
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
