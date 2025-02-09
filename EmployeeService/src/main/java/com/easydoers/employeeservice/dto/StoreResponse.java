package com.easydoers.employeeservice.dto;

import java.util.List;

public class StoreResponse {
	
	private List<StoreDTO> stores;

	/**
	 * @return the stores
	 */
	public List<StoreDTO> getStores() {
		return stores;
	}

	/**
	 * @param stores the stores to set
	 */
	public void setStores(List<StoreDTO> stores) {
		this.stores = stores;
	}
	
	

}
