package com.easydoers.employeeservice.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class InventoryAlertDTO {

	private String dealerStoreId;
	private String storeName;
	private String productName;
	private int minimumQuantity;
	private int currentQuantity;

	/**
	 * @param dealerStoreId
	 * @param storeName
	 * @param productName
	 * @param minimumQuantity
	 * @param currentQuantity
	 */
	public InventoryAlertDTO(String dealerStoreId, String storeName, String productName, int minimumQuantity,
			int currentQuantity) {
		super();
		this.dealerStoreId = dealerStoreId;
		this.storeName = storeName;
		this.productName = productName;
		this.minimumQuantity = minimumQuantity;
		this.currentQuantity = currentQuantity;
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
	 * @return the storeName
	 */
	public String getStoreName() {
		return storeName;
	}

	/**
	 * @param storeName the storeName to set
	 */
	public void setStoreName(String storeName) {
		this.storeName = storeName;
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
	 * @return the minimumQuantity
	 */
	public int getMinimumQuantity() {
		return minimumQuantity;
	}

	/**
	 * @param minimumQuantity the minimumQuantity to set
	 */
	public void setMinimumQuantity(int minimumQuantity) {
		this.minimumQuantity = minimumQuantity;
	}

	/**
	 * @return the currentQuantity
	 */
	public int getCurrentQuantity() {
		return currentQuantity;
	}

	/**
	 * @param currentQuantity the currentQuantity to set
	 */
	public void setCurrentQuantity(int currentQuantity) {
		this.currentQuantity = currentQuantity;
	}

}
