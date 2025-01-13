package com.easydoers.employeeservice.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class LogInResponse {
	
	private EmployeeDTO employee;
	private StoreDTO store;
	private String errorMessage;
	private String bearerToken;
	
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
	 * @param errorMessage
	 * @param bearerToken
	 */
	public LogInResponse(EmployeeDTO employee, StoreDTO store, String errorMessage, String bearerToken) {
		super();
		this.employee = employee;
		this.store = store;
		this.errorMessage = errorMessage;
		this.bearerToken = bearerToken;
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
	 * @return the errorMessage
	 */
	public String getErrorMessage() {
		return errorMessage;
	}

	/**
	 * @param errorMessage the errorMessage to set
	 */
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	/**
	 * @return the bearerToken
	 */
	public String getBearerToken() {
		return bearerToken;
	}

	/**
	 * @param bearerToken the bearerToken to set
	 */
	public void setBearerToken(String bearerToken) {
		this.bearerToken = bearerToken;
	}
}


