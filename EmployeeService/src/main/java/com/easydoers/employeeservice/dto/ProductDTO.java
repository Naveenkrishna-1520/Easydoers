package com.easydoers.employeeservice.dto;

public class ProductDTO {

	private Long id;
	private String productName;
	private int quantity;

	/**
	 * 
	 */
	public ProductDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param productName
	 * @param quantity
	 */
	public ProductDTO(Long id, String productName, int quantity) {
		super();
		this.id = id;
		this.productName = productName;
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
