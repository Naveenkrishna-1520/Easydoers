package com.easydoers.employeeservice.dto;

public class PendingReceivesResponse {
	
	private String deviceName;
	private String imei;
	private String transferedBy;
	private String transferFrom;
	private String date;
	/**
	 * 
	 */
	public PendingReceivesResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param deviceName
	 * @param imei
	 * @param transferedBy
	 * @param transferFrom
	 * @param date
	 */
	public PendingReceivesResponse(String deviceName, String imei, String transferedBy, String transferFrom,
			String date) {
		super();
		this.deviceName = deviceName;
		this.imei = imei;
		this.transferedBy = transferedBy;
		this.transferFrom = transferFrom;
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
	 * @return the transferFrom
	 */
	public String getTransferFrom() {
		return transferFrom;
	}
	/**
	 * @param transferFrom the transferFrom to set
	 */
	public void setTransferFrom(String transferFrom) {
		this.transferFrom = transferFrom;
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
