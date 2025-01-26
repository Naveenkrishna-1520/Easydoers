package com.easydoers.employeeservice.dto;

public class PreviouslySoldDevicesRequest {
	
	private String dealerStoreId;
	private String start;
	private String end;
	/**
	 * @param dealerStoreId
	 * @param start
	 * @param end
	 */
	public PreviouslySoldDevicesRequest(String dealerStoreId, String start, String end) {
		super();
		this.dealerStoreId = dealerStoreId;
		this.start = start;
		this.end = end;
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
	 * @return the start
	 */
	public String getStart() {
		return start;
	}
	/**
	 * @param start the start to set
	 */
	public void setStart(String start) {
		this.start = start;
	}
	/**
	 * @return the end
	 */
	public String getEnd() {
		return end;
	}
	/**
	 * @param end the end to set
	 */
	public void setEnd(String end) {
		this.end = end;
	}
}
