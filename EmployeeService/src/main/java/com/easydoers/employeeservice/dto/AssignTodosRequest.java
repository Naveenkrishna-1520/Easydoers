package com.easydoers.employeeservice.dto;

import java.util.List;

public class AssignTodosRequest {
	

	private String dealerStoreId;
	private List<String> todos;
	/**
	 * 
	 */
	public AssignTodosRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param dealerStoreId
	 * @param todos
	 */
	public AssignTodosRequest(String dealerStoreId, List<String> todos) {
		super();
		this.dealerStoreId = dealerStoreId;
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
