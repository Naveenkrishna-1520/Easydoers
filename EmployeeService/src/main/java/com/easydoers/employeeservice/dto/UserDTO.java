package com.easydoers.employeeservice.dto;

public class UserDTO {
	
	private String userName;
	private String password;
	
	


	/**
	 * 
	 */
	public UserDTO() {
		super();
		// TODO Auto-generated constructor stub
	}




	/**
	 * @param userName
	 * @param password
	 */
	public UserDTO(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}




	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}




	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}




	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}




	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	

}
