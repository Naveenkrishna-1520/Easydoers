package com.easydoers.employeeservice.entity;

import java.time.LocalDate;
import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class StoreTodos {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	@JoinColumn(name = "store_id", nullable = false)
	private Store store;
	@ManyToOne
	@JoinColumn(name = "employee_id")
	private Employee employee;
	private List<String> todos;
	private LocalDate todosDate;
	private boolean completed;
	/**
	 * 
	 */
	public StoreTodos() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param id
	 * @param store
	 * @param employee
	 * @param todos
	 * @param todosDate
	 * @param completed
	 */
	public StoreTodos(Long id, Store store, Employee employee, List<String> todos, LocalDate todosDate,
			boolean completed) {
		super();
		this.id = id;
		this.store = store;
		this.employee = employee;
		this.todos = todos;
		this.todosDate = todosDate;
		this.completed = completed;
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
	 * @return the store
	 */
	public Store getStore() {
		return store;
	}
	/**
	 * @param store the store to set
	 */
	public void setStore(Store store) {
		this.store = store;
	}
	/**
	 * @return the employee
	 */
	public Employee getEmployee() {
		return employee;
	}
	/**
	 * @param employee the employee to set
	 */
	public void setEmployee(Employee employee) {
		this.employee = employee;
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
	/**
	 * @return the todosDate
	 */
	public LocalDate getTodosDate() {
		return todosDate;
	}
	/**
	 * @param todosDate the todosDate to set
	 */
	public void setTodosDate(LocalDate todosDate) {
		this.todosDate = todosDate;
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
	
}
