package com.easydoers.employeeservice.entity;


import java.time.Month;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Compensation {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private double compensationEarned;
	private Month compensationEarnedMonth;
	@OneToOne
	@JoinColumn(name = "store_id")
	private Store store;
	/**
	 * 
	 */
	public Compensation() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param id
	 * @param compensationEarned
	 * @param compensationEarnedMonth
	 * @param store
	 */
	public Compensation(Long id, double compensationEarned, Month compensationEarnedMonth, Store store) {
		super();
		this.id = id;
		this.compensationEarned = compensationEarned;
		this.compensationEarnedMonth = compensationEarnedMonth;
		this.store = store;
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
	 * @return the compensationEarned
	 */
	public double getCompensationEarned() {
		return compensationEarned;
	}
	/**
	 * @param compensationEarned the compensationEarned to set
	 */
	public void setCompensationEarned(double compensationEarned) {
		this.compensationEarned = compensationEarned;
	}
	/**
	 * @return the compensationEarnedMonth
	 */
	public Month getCompensationEarnedMonth() {
		return compensationEarnedMonth;
	}
	/**
	 * @param compensationEarnedMonth the compensationEarnedMonth to set
	 */
	public void setCompensationEarnedMonth(Month compensationEarnedMonth) {
		this.compensationEarnedMonth = compensationEarnedMonth;
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
}
