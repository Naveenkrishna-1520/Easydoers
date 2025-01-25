package com.easydoers.employeeservice.dto;

public class TransferUpgradePhoneRequest {
	
	private String employeeNtid;
	private String targetDealerStoreId;
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
	 * @param targetDealerStoreId
	 * @param imei
	 */
	public TransferUpgradePhoneRequest(String employeeNtid, String targetDealerStoreId, String imei) {
		super();
		this.employeeNtid = employeeNtid;
		this.targetDealerStoreId = targetDealerStoreId;
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
	 * @return the targetDealerStoreId
	 */
	public String getTargetDealerStoreId() {
		return targetDealerStoreId;
	}
	/**
	 * @param targetDealerStoreId the targetDealerStoreId to set
	 */
	public void setTargetDealerStoreId(String targetDealerStoreId) {
		this.targetDealerStoreId = targetDealerStoreId;
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
