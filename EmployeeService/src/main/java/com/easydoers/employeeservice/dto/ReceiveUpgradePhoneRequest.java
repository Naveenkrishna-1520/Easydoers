package com.easydoers.employeeservice.dto;

public class ReceiveUpgradePhoneRequest {
	
	private String receivingDealerStoreId;
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
	 * @param receivingDealerStoreId
	 * @param employeeNtid
	 * @param imei
	 */
	public ReceiveUpgradePhoneRequest(String receivingDealerStoreId, String employeeNtid, String imei) {
		super();
		this.receivingDealerStoreId = receivingDealerStoreId;
		this.employeeNtid = employeeNtid;
		this.imei = imei;
	}
	/**
	 * @return the receivingDealerStoreId
	 */
	public String getReceivingDealerStoreId() {
		return receivingDealerStoreId;
	}
	/**
	 * @param receivingDealerStoreId the receivingDealerStoreId to set
	 */
	public void setReceivingDealerStoreId(String receivingDealerStoreId) {
		this.receivingDealerStoreId = receivingDealerStoreId;
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
