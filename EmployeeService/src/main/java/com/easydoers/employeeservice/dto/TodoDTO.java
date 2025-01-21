package com.easydoers.employeeservice.dto;

public class TodoDTO {
	
	private Long id;
	private boolean completed;
	private String todoDescription;
	/**
	 * 
	 */
	public TodoDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param id
	 * @param completed
	 * @param todoDescription
	 */
	public TodoDTO(Long id, boolean completed, String todoDescription) {
		super();
		this.id = id;
		this.completed = completed;
		this.todoDescription = todoDescription;
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
	 * @return the todoDescription
	 */
	public String getTodoDescription() {
		return todoDescription;
	}
	/**
	 * @param todoDescription the todoDescription to set
	 */
	public void setTodoDescription(String todoDescription) {
		this.todoDescription = todoDescription;
	}
}
