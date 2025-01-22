package com.easydoers.employeeservice.dto;

import java.util.List;

public class UpgradePhonesInvoiceRequest {
	
	private String employeeNtid;
	private String dealerStoreId;
	private Long accountNumber;
	private String activatedDate;
	private double amount;
	List<UpgradePhonesProductDTO> products;
	/**
	 * 
	 */
	public UpgradePhonesInvoiceRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param employeeNtid
	 * @param dealerStoreId
	 * @param accountNumber
	 * @param activatedDate
	 * @param amount
	 * @param products
	 */
	public UpgradePhonesInvoiceRequest(String employeeNtid, String dealerStoreId, Long accountNumber,
			String activatedDate, double amount, List<UpgradePhonesProductDTO> products) {
		super();
		this.employeeNtid = employeeNtid;
		this.dealerStoreId = dealerStoreId;
		this.accountNumber = accountNumber;
		this.activatedDate = activatedDate;
		this.amount = amount;
		this.products = products;
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
	 * @return the accountNumber
	 */
	public Long getAccountNumber() {
		return accountNumber;
	}
	/**
	 * @param accountNumber the accountNumber to set
	 */
	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}
	/**
	 * @return the activatedDate
	 */
	public String getActivatedDate() {
		return activatedDate;
	}
	/**
	 * @param activatedDate the activatedDate to set
	 */
	public void setActivatedDate(String activatedDate) {
		this.activatedDate = activatedDate;
	}
	/**
	 * @return the amount
	 */
	public double getAmount() {
		return amount;
	}
	/**
	 * @param amount the amount to set
	 */
	public void setAmount(double amount) {
		this.amount = amount;
	}
	/**
	 * @return the products
	 */
	public List<UpgradePhonesProductDTO> getProducts() {
		return products;
	}
	/**
	 * @param products the products to set
	 */
	public void setProducts(List<UpgradePhonesProductDTO> products) {
		this.products = products;
	}
}
