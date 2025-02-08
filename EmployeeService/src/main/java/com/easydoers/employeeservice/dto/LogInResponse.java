package com.easydoers.employeeservice.dto;

import java.time.LocalTime;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class LogInResponse {

	private EmployeeDTO employee;
	private StoreDTO store;
	@JsonIgnore
	private String token;
	@JsonIgnore
	private String refreshToken;
	private String isClockin;
	private String clockinLocation;
	private String isSaleSubmit;
	private LocalTime clockinTime;
	private String loginEmail;
	private String loginPerson;

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
	 * @param clockinLocation
	 * @param isSaleSubmit
	 * @param clockinTime
	 * @param loginEmail
	 * @param loginPerson
	 */
	public LogInResponse(EmployeeDTO employee, StoreDTO store, String token, String refreshToken, String isClockin,
			String clockinLocation, String isSaleSubmit, LocalTime clockinTime, String loginEmail, String loginPerson) {
		super();
		this.employee = employee;
		this.store = store;
		this.token = token;
		this.refreshToken = refreshToken;
		this.isClockin = isClockin;
		this.clockinLocation = clockinLocation;
		this.isSaleSubmit = isSaleSubmit;
		this.clockinTime = clockinTime;
		this.loginEmail = loginEmail;
		this.loginPerson = loginPerson;
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
	public String getIsClockin() {
		return isClockin;
	}

	/**
	 * @param isClockin the isClockin to set
	 */
	public void setIsClockin(String isClockin) {
		this.isClockin = isClockin;
	}

	/**
	 * @return the clockinLocation
	 */
	public String getClockinLocation() {
		return clockinLocation;
	}

	/**
	 * @param clockinLocation the clockinLocation to set
	 */
	public void setClockinLocation(String clockinLocation) {
		this.clockinLocation = clockinLocation;
	}

	/**
	 * @return the isSaleSubmit
	 */
	public String getIsSaleSubmit() {
		return isSaleSubmit;
	}

	/**
	 * @param isSaleSubmit the isSaleSubmit to set
	 */
	public void setIsSaleSubmit(String isSaleSubmit) {
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

	/**
	 * @return the loginEmail
	 */
	public String getLoginEmail() {
		return loginEmail;
	}

	/**
	 * @param loginEmail the loginEmail to set
	 */
	public void setLoginEmail(String loginEmail) {
		this.loginEmail = loginEmail;
	}

	/**
	 * @return the loginPerson
	 */
	public String getLoginPerson() {
		return loginPerson;
	}

	/**
	 * @param loginPerson the loginPerson to set
	 */
	public void setLoginPerson(String loginPerson) {
		this.loginPerson = loginPerson;
	}
}
