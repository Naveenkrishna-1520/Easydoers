package com.easydoers.employeeservice.dto;

import java.util.List;

public class AuthorizedStoreAccessResponse {
	
	private List<StoreDTO> stores;

	/**
	 * 
	 */
	public AuthorizedStoreAccessResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param stores
	 */
	public AuthorizedStoreAccessResponse(List<StoreDTO> stores) {
		super();
		this.stores = stores;
	}

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
