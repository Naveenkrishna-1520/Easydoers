package com.easydoers.employeeservice.dto;



public class UpgradePhonesSoldRequest {
	
	private String employeeNtid;
	private String dealerStoreId;
	private String soldTo;
	private double soldPrice;
	private String soldDate;
	private UpgradePhonesProductDTO product;
	/**
	 * 
	 */
	public UpgradePhonesSoldRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param employeeNtid
	 * @param dealerStoreId
	 * @param soldTo
	 * @param soldPrice
	 * @param soldDate
	 * @param product
	 */
	public UpgradePhonesSoldRequest(String employeeNtid, String dealerStoreId, String soldTo, double soldPrice,
			String soldDate, UpgradePhonesProductDTO product) {
		super();
		this.employeeNtid = employeeNtid;
		this.dealerStoreId = dealerStoreId;
		this.soldTo = soldTo;
		this.soldPrice = soldPrice;
		this.soldDate = soldDate;
		this.product = product;
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
	 * @return the dealerStoreId
	 */
	public String getDealerStoreId() {
		return dealerStoreId;
	}
	/**
	 * @param dealerStoreId the dealerStoreId to set
	 */
	public void setDealerStoreId(String dealerStoreId) {
		this.dealerStoreId = dealerStoreId;
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
	 * @return the product
	 */
	public UpgradePhonesProductDTO getProduct() {
		return product;
	}
	/**
	 * @param product the product to set
	 */
	public void setProduct(UpgradePhonesProductDTO product) {
		this.product = product;
	}
}
