package com.easydoers.employeeservice.dto;

public class UpgradePhonesDTO {
	
	private Long id;
	private String productName;
	private String imei;
	private int quantity;
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
	 * @param quantity
	 */
	public UpgradePhonesDTO(Long id, String productName, String imei, int quantity) {
		super();
		this.id = id;
		this.productName = productName;
		this.imei = imei;
		this.quantity = quantity;
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
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}
	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
}
