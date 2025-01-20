package com.easydoers.employeeservice.dto;

import java.util.List;

public class AddMinimumInventoryRequest {
	
	private String dealerStoreId;
	private List<ProductDTO> products;
	
	
	/**
	 * 
	 */
	public AddMinimumInventoryRequest() {
		super();
		// TODO Auto-generated constructor stub
	}


	/**
	 * @param dealerStoreId
	 * @param products
	 */
	public AddMinimumInventoryRequest(String dealerStoreId, List<ProductDTO> products) {
		super();
		this.dealerStoreId = dealerStoreId;
		this.products = products;
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
	 * @return the products
	 */
	public List<ProductDTO> getProducts() {
		return products;
	}


	/**
	 * @param products the products to set
	 */
	public void setProducts(List<ProductDTO> products) {
		this.products = products;
	}
	
}
