package com.easydoers.employeeservice.dto;

import java.util.List;

public class GetAssignedTodosForStoreResponse {

	private String dealerStoreId;
	private List<String> todos;
	
	/**
	 * @param dealerStoreId
	 * @param todos
	 */
	public GetAssignedTodosForStoreResponse(String dealerStoreId, List<String> todos) {
		super();
		this.dealerStoreId = dealerStoreId;
		this.todos = todos;
	}
	/**
	 * 
	 */
	public GetAssignedTodosForStoreResponse() {
		super();
		// TODO Auto-generated constructor stub
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
