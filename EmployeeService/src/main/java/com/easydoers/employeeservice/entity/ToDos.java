package com.easydoers.employeeservice.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ToDos {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String toDos;
	/**
	 * 
	 */
	public ToDos() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param id
	 * @param toDos
	 */
	public ToDos(Long id, String toDos) {
		super();
		this.id = id;
		this.toDos = toDos;
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
	 * @return the toDos
	 */
	public String getToDos() {
		return toDos;
	}
	/**
	 * @param toDos the toDos to set
	 */
	public void setToDos(String toDos) {
		this.toDos = toDos;
	}
}
