package com.easydoers.employeeservice.dto;



public class TodosCompletedEmployeeRequest {

	private Long id;
	private boolean completed;
	private String employeeNtid;
	

	/**
	 * 
	 */
	public TodosCompletedEmployeeRequest() {
		super();
		// TODO Auto-generated constructor stub
	}


	/**
	 * @param id
	 * @param completed
	 * @param employeeNtid
	 */
	public TodosCompletedEmployeeRequest(Long id, boolean completed, String employeeNtid) {
		super();
		this.id = id;
		this.completed = completed;
		this.employeeNtid = employeeNtid;
	}


	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}


	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}


	/**
	 * @return the completed
	 */
	public boolean isCompleted() {
		return completed;
	}


	/**
	 * @param completed the completed to set
	 */
	public void setCompleted(boolean completed) {
		this.completed = completed;
	}


	/**
	 * @return the employeeNtid
	 */
	public String getEmployeeNtid() {
		return employeeNtid;
	}


	/**
	 * @param employeeNtid the employeeNtid to set
	 */
	public void setEmployeeNtid(String employeeNtid) {
		this.employeeNtid = employeeNtid;
	}
}
