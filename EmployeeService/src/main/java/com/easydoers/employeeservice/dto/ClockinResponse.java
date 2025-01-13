package com.easydoers.employeeservice.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ClockinResponse {

	private boolean isClockin;
	private String message;

	/**
	 * 
	 */
	public ClockinResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param isClockin
	 * @param message
	 */
	public ClockinResponse(boolean isClockin, String message) {
		super();
		this.isClockin = isClockin;
		this.message = message;
	}

	/**
	 * @return the isClockin
	 */
	public boolean isClockin() {
		return isClockin;
	}

	/**
	 * @param isClockin the isClockin to set
	 */
	public void setClockin(boolean isClockin) {
		this.isClockin = isClockin;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

}
