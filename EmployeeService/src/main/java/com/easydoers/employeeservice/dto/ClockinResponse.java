package com.easydoers.employeeservice.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ClockinResponse {

	private boolean isClockin;

	/**
	 * 
	 */
	public ClockinResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param isClockin
	 */
	public ClockinResponse(boolean isClockin) {
		super();
		this.isClockin = isClockin;
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

	
}
