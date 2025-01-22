package com.easydoers.employeeservice.dto;

import java.util.List;

public class UpgradePhonesInStoresResponse {
	
	private StoreDTO store;
	List<UpgradePhonesDTO> products;

	/**
	 * 
	 */
	public UpgradePhonesInStoresResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param store
	 * @param products
	 */
	public UpgradePhonesInStoresResponse(StoreDTO store, List<UpgradePhonesDTO> products) {
		super();
		this.store = store;
		this.products = products;
	}

	/**
	 * @return the store
	 */
	public StoreDTO getStore() {
		return store;
	}

	/**
	 * @param store the store to set
	 */
	public void setStore(StoreDTO store) {
		this.store = store;
	}

	/**
	 * @return the products
	 */
	public List<UpgradePhonesDTO> getProducts() {
		return products;
	}

	/**
	 * @param products the products to set
	 */
	public void setProducts(List<UpgradePhonesDTO> products) {
		this.products = products;
	}

}
