package com.easydoers.employeeservice.dto;



public class CashCollectionResponse {
	
	private StoreDTO store;
	private CashDTO cash;
	
	
	
	/**
	 * 
	 */
	public CashCollectionResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param store
	 * @param cash
	 */
	public CashCollectionResponse(StoreDTO store, CashDTO cash) {
		super();
		this.store = store;
		this.cash = cash;
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
	 * @return the cash
	 */
	public CashDTO getCash() {
		return cash;
	}
	/**
	 * @param cash the cash to set
	 */
	public void setCash(CashDTO cash) {
		this.cash = cash;
	}
	
	

}
