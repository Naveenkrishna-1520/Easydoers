package com.easydoers.employeeservice.dto;

import java.util.List;

public class CashCollectionResponse {

	private StoreDTO store;
	private CashDTO cash;
	private List<SaleHistoryDTO> saleHistory;

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
	 * @param saleHistory
	 */
	public CashCollectionResponse(StoreDTO store, CashDTO cash, List<SaleHistoryDTO> saleHistory) {
		super();
		this.store = store;
		this.cash = cash;
		this.saleHistory = saleHistory;
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

	/**
	 * @return the saleHistory
	 */
	public List<SaleHistoryDTO> getSaleHistory() {
		return saleHistory;
	}

	/**
	 * @param saleHistory the saleHistory to set
	 */
	public void setSaleHistory(List<SaleHistoryDTO> saleHistory) {
		this.saleHistory = saleHistory;
	}

}
