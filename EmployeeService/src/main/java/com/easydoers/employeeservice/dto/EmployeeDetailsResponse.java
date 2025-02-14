package com.easydoers.employeeservice.dto;

import java.util.List;


public class EmployeeDetailsResponse {
	
	private List<EmployeeDetailsDTO> employees;
	
	

	/**
	 * 
	 */
	public EmployeeDetailsResponse() {
		super();
		// TODO Auto-generated constructor stub
	}



	/**
	 * @param employees
	 */
	public EmployeeDetailsResponse(List<EmployeeDetailsDTO> employees) {
		super();
		this.employees = employees;
	}

	

	/**
	 * @return the employees
	 */
	public List<EmployeeDetailsDTO> getEmployees() {
		return employees;
	}

	/**
	 * @param employees the employees to set
	 */
	public void setEmployees(List<EmployeeDetailsDTO> employees) {
		this.employees = employees;
	}
	
	

}
