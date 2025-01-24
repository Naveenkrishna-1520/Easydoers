package com.easydoers.employeeservice.dto;

public class PendingTranfersResponse {
	
	private String deviceName;
	private String imei;
	private String transferedBy;
	private String transferTo;
	private String date;
	/**
	 * 
	 */
	public PendingTranfersResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param deviceName
	 * @param imei
	 * @param transferedBy
	 * @param transferTo
	 * @param date
	 */
	public PendingTranfersResponse(String deviceName, String imei, String transferedBy, String transferTo, String date) {
		super();
		this.deviceName = deviceName;
		this.imei = imei;
		this.transferedBy = transferedBy;
		this.transferTo = transferTo;
		this.date = date;
	}
	/**
	 * @return the deviceName
	 */
	public String getDeviceName() {
		return deviceName;
	}
	/**
	 * @param deviceName the deviceName to set
	 */
	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
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
	/**
	 * @return the transferedBy
	 */
	public String getTransferedBy() {
		return transferedBy;
	}
	/**
	 * @param transferedBy the transferedBy to set
	 */
	public void setTransferedBy(String transferedBy) {
		this.transferedBy = transferedBy;
	}
	/**
	 * @return the transferTo
	 */
	public String getTransferTo() {
		return transferTo;
	}
	/**
	 * @param transferTo the transferTo to set
	 */
	public void setTransferTo(String transferTo) {
		this.transferTo = transferTo;
	}
	/**
	 * @return the date
	 */
	public String getDate() {
		return date;
	}
	/**
	 * @param date the date to set
	 */
	public void setDate(String date) {
		this.date = date;
	}
	
	

}
