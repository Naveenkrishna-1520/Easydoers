package com.easydoers.employeeservice.dto;

import java.util.List;

public class TodosCompletedEmployeeRequest {

	private String dealerStoreId;
	private String employeeNtid;
	private List<String> todos;

	/**
	 * 
	 */
	public TodosCompletedEmployeeRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param dealerStoreId
	 * @param employeeNtid
	 * @param todos
	 */
	public TodosCompletedEmployeeRequest(String dealerStoreId, String employeeNtid, List<String> todos) {
		super();
		this.dealerStoreId = dealerStoreId;
		this.employeeNtid = employeeNtid;
		this.todos = todos;
	}

	/**
	 * @return the dealerStoreId
	 */
	public String getDealerStoreId() {
		return dealerStoreId;
	}

	/**
	 * @param dealerStoreId the dealerStoreId to set
	 */
	public void setDealerStoreId(String dealerStoreId) {
		this.dealerStoreId = dealerStoreId;
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

	/**
	 * @return the todos
	 */
	public List<String> getTodos() {
		return todos;
	}

	/**
	 * @param todos the todos to set
	 */
	public void setTodos(List<String> todos) {
		this.todos = todos;
	}

}
