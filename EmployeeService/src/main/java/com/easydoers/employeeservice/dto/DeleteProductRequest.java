package com.easydoers.employeeservice.dto;

public class DeleteProductRequest {
	
	private String dealerStoreId;
	private ProductDTO product;
	/**
	 * 
	 */
	public DeleteProductRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param dealerStoreId
	 * @param product
	 */
	public DeleteProductRequest(String dealerStoreId, ProductDTO product) {
		super();
		this.dealerStoreId = dealerStoreId;
		this.product = product;
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
	 * @return the product
	 */
	public ProductDTO getProduct() {
		return product;
	}
	/**
	 * @param product the product to set
	 */
	public void setProduct(ProductDTO product) {
		this.product = product;
	}
}
