package com.easydoers.employeeservice.dto;

public class previouslySoldDevicesResponse {
	
	private String imei;
	private String productName;
	private String soldTo;
	private String soldDate;
	private String soldBy;
	private String soldAt;
	private double soldPrice;
	/**
	 * 
	 */
	public previouslySoldDevicesResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param imei
	 * @param productName
	 * @param soldTo
	 * @param soldDate
	 * @param soldBy
	 * @param soldAt
	 * @param soldPrice
	 */
	public previouslySoldDevicesResponse(String imei, String productName, String soldTo, String soldDate, String soldBy,
			String soldAt, double soldPrice) {
		super();
		this.imei = imei;
		this.productName = productName;
		this.soldTo = soldTo;
		this.soldDate = soldDate;
		this.soldBy = soldBy;
		this.soldAt = soldAt;
		this.soldPrice = soldPrice;
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
	 * @return the productName
	 */
	public String getProductName() {
		return productName;
	}
	/**
	 * @param productName the productName to set
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}
	/**
	 * @return the soldTo
	 */
	public String getSoldTo() {
		return soldTo;
	}
	/**
	 * @param soldTo the soldTo to set
	 */
	public void setSoldTo(String soldTo) {
		this.soldTo = soldTo;
	}
	/**
	 * @return the soldDate
	 */
	public String getSoldDate() {
		return soldDate;
	}
	/**
	 * @param soldDate the soldDate to set
	 */
	public void setSoldDate(String soldDate) {
		this.soldDate = soldDate;
	}
	/**
	 * @return the soldBy
	 */
	public String getSoldBy() {
		return soldBy;
	}
	/**
	 * @param soldBy the soldBy to set
	 */
	public void setSoldBy(String soldBy) {
		this.soldBy = soldBy;
	}
	/**
	 * @return the soldAt
	 */
	public String getSoldAt() {
		return soldAt;
	}
	/**
	 * @param soldAt the soldAt to set
	 */
	public void setSoldAt(String soldAt) {
		this.soldAt = soldAt;
	}
	/**
	 * @return the soldPrice
	 */
	public double getSoldPrice() {
		return soldPrice;
	}
	/**
	 * @param soldPrice the soldPrice to set
	 */
	public void setSoldPrice(double soldPrice) {
		this.soldPrice = soldPrice;
	}
}
