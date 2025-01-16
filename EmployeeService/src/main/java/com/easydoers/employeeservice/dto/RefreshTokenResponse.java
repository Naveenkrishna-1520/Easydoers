package com.easydoers.employeeservice.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class RefreshTokenResponse {
	
	@JsonIgnore
	private String accesstoken;
	private boolean tokenRefreshed;
	
	
	/**
	 * 
	 */
	public RefreshTokenResponse() {
		super();
		// TODO Auto-generated constructor stub
	}


	/**
	 * @param accesstoken
	 * @param tokenRefreshed
	 */
	public RefreshTokenResponse(String accesstoken, boolean tokenRefreshed) {
		super();
		this.accesstoken = accesstoken;
		this.tokenRefreshed = tokenRefreshed;
	}


	/**
	 * @return the accesstoken
	 */
	public String getAccesstoken() {
		return accesstoken;
	}


	/**
	 * @param accesstoken the accesstoken to set
	 */
	public void setAccesstoken(String accesstoken) {
		this.accesstoken = accesstoken;
	}


	/**
	 * @return the tokenRefreshed
	 */
	public boolean isTokenRefreshed() {
		return tokenRefreshed;
	}


	/**
	 * @param tokenRefreshed the tokenRefreshed to set
	 */
	public void setTokenRefreshed(boolean tokenRefreshed) {
		this.tokenRefreshed = tokenRefreshed;
	}
	
	
	

}
