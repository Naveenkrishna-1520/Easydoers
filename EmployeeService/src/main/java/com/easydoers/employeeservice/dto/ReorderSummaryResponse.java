package com.easydoers.employeeservice.dto;

import java.util.List;

public class ReorderSummaryResponse {
	
	private StoreDTO store;
	private List<InventoryAlertDTO> inventory;
	
	
	/**
	 * 
	 */
	public ReorderSummaryResponse() {
		super();
		// TODO Auto-generated constructor stub
	}


	/**
	 * @param store
	 * @param inventory
	 */
	public ReorderSummaryResponse(StoreDTO store, List<InventoryAlertDTO> inventory) {
		super();
		this.store = store;
		this.inventory = inventory;
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
	 * @return the inventory
	 */
	public List<InventoryAlertDTO> getInventory() {
		return inventory;
	}


	/**
	 * @param inventory the inventory to set
	 */
	public void setInventory(List<InventoryAlertDTO> inventory) {
		this.inventory = inventory;
	}
	
}
