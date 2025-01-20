package com.easydoers.employeeservice.dto;


public class PayslipResponse {
	
	private String paySlip;

	
	/**
	 * 
	 */
	public PayslipResponse() {
		super();
		// TODO Auto-generated constructor stub
	}


	/**
	 * @param paySlip
	 */
	public PayslipResponse(String paySlip) {
		super();
		this.paySlip = paySlip;
	}


	/**
	 * @return the paySlip
	 */
	public String getPaySlip() {
		return paySlip;
	}


	/**
	 * @param paySlip the paySlip to set
	 */
	public void setPaySlip(String paySlip) {
		this.paySlip = paySlip;
	}


	@Override
	public String toString() {
		return "" + paySlip + "";
	}
	

}
