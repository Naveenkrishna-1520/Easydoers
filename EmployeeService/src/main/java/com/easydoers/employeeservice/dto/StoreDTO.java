package com.easydoers.employeeservice.dto;

public class StoreDTO {
	
    private String dealerStoreId;
    private String storeName;
    
    
	/**
	 * 
	 */
	public StoreDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param dealerStoreId
	 * @param storeName
	 */
	public StoreDTO(String dealerStoreId, String storeName) {
		super();
		this.dealerStoreId = dealerStoreId;
		this.storeName = storeName;
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
	@Override
	public String toString() {
		return "[dealerStoreId=" + dealerStoreId + ", storeName=" + storeName + "]";
	}
	
    
	
    
}

