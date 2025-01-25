package com.easydoers.employeeservice.dto;

public class previouslySoldDevicesResponse {
	
	private String productName;
	private String soldTo;
	private String solddate;
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
	 * @param productName
	 * @param soldTo
	 * @param solddate
	 * @param soldBy
	 * @param soldAt
	 * @param soldPrice
	 */
	public previouslySoldDevicesResponse(String productName, String soldTo, String solddate, String soldBy,
			String soldAt, double soldPrice) {
		super();
		this.productName = productName;
		this.soldTo = soldTo;
		this.solddate = solddate;
		this.soldBy = soldBy;
		this.soldAt = soldAt;
		this.soldPrice = soldPrice;
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
	 * @return the solddate
	 */
	public String getSolddate() {
		return solddate;
	}
	/**
	 * @param solddate the solddate to set
	 */
	public void setSolddate(String solddate) {
		this.solddate = solddate;
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
