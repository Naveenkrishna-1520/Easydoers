package com.easydoers.employeeservice.dto;

import java.util.List;

public class GetAssignedTodosForStoreResponse {

	
	private List<TodoDTO> todos;

	/**
	 * 
	 */
	public GetAssignedTodosForStoreResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param todos
	 */
	public GetAssignedTodosForStoreResponse(List<TodoDTO> todos) {
		super();
		this.todos = todos;
	}

	/**
	 * @return the todos
	 */
	public List<TodoDTO> getTodos() {
		return todos;
	}

	/**
	 * @param todos the todos to set
	 */
	public void setTodos(List<TodoDTO> todos) {
		this.todos = todos;
	}
}
