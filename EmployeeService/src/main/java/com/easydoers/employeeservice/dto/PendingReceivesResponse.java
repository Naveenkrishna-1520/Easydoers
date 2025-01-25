package com.easydoers.employeeservice.dto;

public class PendingReceivesResponse {
	
	private String deviceName;
	private String imei;
	private String transferredBy;
	private String transferredFrom;
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
	 * @param transferredBy
	 * @param transferredFrom
	 * @param date
	 */
	public PendingReceivesResponse(String deviceName, String imei, String transferredBy, String transferredFrom,
			String date) {
		super();
		this.deviceName = deviceName;
		this.imei = imei;
		this.transferredBy = transferredBy;
		this.transferredFrom = transferredFrom;
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
	 * @return the transferredBy
	 */
	public String getTransferredBy() {
		return transferredBy;
	}
	/**
	 * @param transferredBy the transferredBy to set
	 */
	public void setTransferredBy(String transferredBy) {
		this.transferredBy = transferredBy;
	}
	/**
	 * @return the transferredFrom
	 */
	public String getTransferredFrom() {
		return transferredFrom;
	}
	/**
	 * @param transferredFrom the transferredFrom to set
	 */
	public void setTransferredFrom(String transferredFrom) {
		this.transferredFrom = transferredFrom;
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
