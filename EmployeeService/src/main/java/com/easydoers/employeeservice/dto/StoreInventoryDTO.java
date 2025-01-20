package com.easydoers.employeeservice.dto;

import java.util.List;

public class StoreInventoryDTO {
	
	private List<ProductDTO> products;
	
	/**
	 * 
	 */
	public StoreInventoryDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param products
	 */
	public StoreInventoryDTO(List<ProductDTO> products) {
		super();
		this.products = products;
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
