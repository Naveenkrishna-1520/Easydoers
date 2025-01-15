package com.easydoers.employeeservice.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class LogInResponse {
	
	private EmployeeDTO employee;
	private StoreDTO store;
	@JsonIgnore
	private String token;
	private boolean isClockin;
	private boolean isSaleSubmit;
	
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
	 * @param isClockin
	 * @param isSaleSubmit
	 */
	public LogInResponse(EmployeeDTO employee, StoreDTO store, String token, boolean isClockin, boolean isSaleSubmit) {
		super();
		this.employee = employee;
		this.store = store;
		this.token = token;
		this.isClockin = isClockin;
		this.isSaleSubmit = isSaleSubmit;
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

	
}


