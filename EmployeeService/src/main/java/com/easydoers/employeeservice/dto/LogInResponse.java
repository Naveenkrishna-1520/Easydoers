package com.easydoers.employeeservice.dto;

import java.time.LocalTime;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class LogInResponse {

	private EmployeeDTO employee;
	private StoreDTO store;
	@JsonIgnore
	private String token;
	@JsonIgnore
	private String refreshToken;
	private boolean isClockin;
	private boolean isSaleSubmit;
	private LocalTime clockinTime;

	/**
	 * 
	 */
	public LogInResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param employee
	 * @param store
	 * @param token
	 * @param refreshToken
	 * @param isClockin
	 * @param isSaleSubmit
	 * @param clockinTime
	 */
	public LogInResponse(EmployeeDTO employee, StoreDTO store, String token, String refreshToken, boolean isClockin,
			boolean isSaleSubmit, LocalTime clockinTime) {
		super();
		this.employee = employee;
		this.store = store;
		this.token = token;
		this.refreshToken = refreshToken;
		this.isClockin = isClockin;
		this.isSaleSubmit = isSaleSubmit;
		this.clockinTime = clockinTime;
	}

	/**
	 * @return the employee
	 */
	public EmployeeDTO getEmployee() {
		return employee;
	}

	/**
	 * @param employee the employee to set
	 */
	public void setEmployee(EmployeeDTO employee) {
		this.employee = employee;
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
	 * @return the token
	 */
	public String getToken() {
		return token;
	}

	/**
	 * @param token the token to set
	 */
	public void setToken(String token) {
		this.token = token;
	}

	/**
	 * @return the refreshToken
	 */
	public String getRefreshToken() {
		return refreshToken;
	}

	/**
	 * @param refreshToken the refreshToken to set
	 */
	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
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
	 * @return the isSaleSubmit
	 */
	public boolean isSaleSubmit() {
		return isSaleSubmit;
	}

	/**
	 * @param isSaleSubmit the isSaleSubmit to set
	 */
	public void setSaleSubmit(boolean isSaleSubmit) {
		this.isSaleSubmit = isSaleSubmit;
	}

	/**
	 * @return the clockinTime
	 */
	public LocalTime getClockinTime() {
		return clockinTime;
	}

	/**
	 * @param clockinTime the clockinTime to set
	 */
	public void setClockinTime(LocalTime clockinTime) {
		this.clockinTime = clockinTime;
	}

}
