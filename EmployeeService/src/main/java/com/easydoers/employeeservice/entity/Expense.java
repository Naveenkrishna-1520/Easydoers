package com.easydoers.employeeservice.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Expense {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String paidFor;
	private double amount;
	@ManyToOne
	@JoinColumn(name = "store_id")
	private Store store;
	private LocalDate expenseRecordedDate;
	/**
	 * 
	 */
	public Expense() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param id
	 * @param paidFor
	 * @param amount
	 * @param store
	 * @param expenseRecordedDate
	 */
	public Expense(Long id, String paidFor, double amount, Store store, LocalDate expenseRecordedDate) {
		super();
		this.id = id;
		this.paidFor = paidFor;
		this.amount = amount;
		this.store = store;
		this.expenseRecordedDate = expenseRecordedDate;
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
	 * @return the paidFor
	 */
	public String getPaidFor() {
		return paidFor;
	}
	/**
	 * @param paidFor the paidFor to set
	 */
	public void setPaidFor(String paidFor) {
		this.paidFor = paidFor;
	}
	/**
	 * @return the amount
	 */
	public double getAmount() {
		return amount;
	}
	/**
	 * @param amount the amount to set
	 */
	public void setAmount(double amount) {
		this.amount = amount;
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
	 * @return the expenseRecordedDate
	 */
	public LocalDate getExpenseRecordedDate() {
		return expenseRecordedDate;
	}
	/**
	 * @param expenseRecordedDate the expenseRecordedDate to set
	 */
	public void setExpenseRecordedDate(LocalDate expenseRecordedDate) {
		this.expenseRecordedDate = expenseRecordedDate;
	}
}
