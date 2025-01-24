package com.easydoers.employeeservice.dto;

import java.util.List;

public class PendingTransfersAndReceivesResponse {
	
	private List<PendingTranfersResponse> pendingTransfers;
	private List<PendingReceivesResponse> pendingReceives;
	/**
	 * 
	 */
	public PendingTransfersAndReceivesResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param pendingTransfers
	 * @param pendingReceives
	 */
	public PendingTransfersAndReceivesResponse(List<PendingTranfersResponse> pendingTransfers,
			List<PendingReceivesResponse> pendingReceives) {
		super();
		this.pendingTransfers = pendingTransfers;
		this.pendingReceives = pendingReceives;
	}
	/**
	 * @return the pendingTransfers
	 */
	public List<PendingTranfersResponse> getPendingTransfers() {
		return pendingTransfers;
	}
	/**
	 * @param pendingTransfers the pendingTransfers to set
	 */
	public void setPendingTransfers(List<PendingTranfersResponse> pendingTransfers) {
		this.pendingTransfers = pendingTransfers;
	}
	/**
	 * @return the pendingReceives
	 */
	public List<PendingReceivesResponse> getPendingReceives() {
		return pendingReceives;
	}
	/**
	 * @param pendingReceives the pendingReceives to set
	 */
	public void setPendingReceives(List<PendingReceivesResponse> pendingReceives) {
		this.pendingReceives = pendingReceives;
	}
}
