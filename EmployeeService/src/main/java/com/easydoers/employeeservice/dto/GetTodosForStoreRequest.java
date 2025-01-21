package com.easydoers.employeeservice.dto;

public class GetTodosForStoreRequest {
	
	private String dealerStoreId;
	private String date;
	/**
	 * 
	 */
	public GetTodosForStoreRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param dealerStoreId
	 * @param date
	 */
	public GetTodosForStoreRequest(String dealerStoreId, String date) {
		super();
		this.dealerStoreId = dealerStoreId;
		this.date = date;
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
	 * @return the date
	 */
	public String getDate() {
		return date;
	}
	/**
	 * @param date the date to set
	 */
	public void setDate(String date) {
		this.date = date;
	}
}
