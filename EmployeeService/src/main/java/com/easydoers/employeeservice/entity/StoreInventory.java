package com.easydoers.employeeservice.entity;

import jakarta.persistence.*;

@Entity
public class StoreInventory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "store_id", nullable = false)
	private Store store;

	@ManyToOne
	@JoinColumn(name = "product_id", nullable = false)
	private Product product;
	private int quantity;
	private int minimumQuantity;

	/**
	 * 
	 */
	public StoreInventory() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param store
	 * @param product
	 * @param quantity
	 * @param minimumQuantity
	 */
	public StoreInventory(Long id, Store store, Product product, int quantity, int minimumQuantity) {
		super();
		this.id = id;
		this.store = store;
		this.product = product;
		this.quantity = quantity;
		this.minimumQuantity = minimumQuantity;
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
	 * @return the store
	 */
	public Store getStore() {
		return store;
	}

	/**
	 * @param store the store to set
	 */
	public void setStore(Store store) {
		this.store = store;
	}

	/**
	 * @return the product
	 */
	public Product getProduct() {
		return product;
	}

	/**
	 * @param product the product to set
	 */
	public void setProduct(Product product) {
		this.product = product;
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

}
