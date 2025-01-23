package com.easydoers.employeeservice.dto;

public class UpgradePhonesDTO {
	
	private Long id;
	private String productName;
	private String imei;
	private String phoneNumber;
	private String activationDate;
	private Long daysOld;
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
	 * @param activationDate
	 * @param daysOld
	 */
	public UpgradePhonesDTO(Long id, String productName, String imei, String phoneNumber, String activationDate,
			Long daysOld) {
		super();
		this.id = id;
		this.productName = productName;
		this.imei = imei;
		this.phoneNumber = phoneNumber;
		this.activationDate = activationDate;
		this.daysOld = daysOld;
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
	/**
	 * @return the activationDate
	 */
	public String getActivationDate() {
		return activationDate;
	}
	/**
	 * @param activationDate the activationDate to set
	 */
	public void setActivationDate(String activationDate) {
		this.activationDate = activationDate;
	}
	/**
	 * @return the daysOld
	 */
	public Long getDaysOld() {
		return daysOld;
	}
	/**
	 * @param daysOld the daysOld to set
	 */
	public void setDaysOld(Long daysOld) {
		this.daysOld = daysOld;
	}
	
}
