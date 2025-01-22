package com.easydoers.employeeservice.dto;

public class UpgradePhonesProductDTO {
	
	private String productName;
	private String imei;
	private String phoneNumber;
	/**
	 * 
	 */
	public UpgradePhonesProductDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param productName
	 * @param imei
	 * @param phoneNumber
	 */
	public UpgradePhonesProductDTO(String productName, String imei, String phoneNumber) {
		super();
		this.productName = productName;
		this.imei = imei;
		this.phoneNumber = phoneNumber;
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
	 * @return the phoneNumber
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}
	/**
	 * @param phoneNumber the phoneNumber to set
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
}
