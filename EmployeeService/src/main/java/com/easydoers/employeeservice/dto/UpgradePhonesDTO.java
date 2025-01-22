package com.easydoers.employeeservice.dto;

public class UpgradePhonesDTO {
	
	private Long id;
	private String productName;
	private String imei;
	private String phoneNumber;
	/**
	 * 
	 */
	public UpgradePhonesDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param id
	 * @param productName
	 * @param imei
	 * @param phoneNumber
	 */
	public UpgradePhonesDTO(Long id, String productName, String imei, String phoneNumber) {
		super();
		this.id = id;
		this.productName = productName;
		this.imei = imei;
		this.phoneNumber = phoneNumber;
	}
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
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
