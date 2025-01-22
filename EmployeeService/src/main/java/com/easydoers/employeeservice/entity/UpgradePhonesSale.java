package com.easydoers.employeeservice.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class UpgradePhonesSale {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long saleId;
	private String soldTo;
	private LocalDate soldDate;
	private double soldPrice;
	@ManyToOne
	@JoinColumn(name = "store_id", nullable = false)
	private Store soldStore;
	@ManyToOne
	@JoinColumn(name = "employee_id", nullable = false) 
	private Employee soldEmployee;
	/**
	 * 
	 */
	public UpgradePhonesSale() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param saleId
	 * @param soldTo
	 * @param soldDate
	 * @param soldPrice
	 * @param soldStore
	 * @param soldEmployee
	 */
	public UpgradePhonesSale(Long saleId, String soldTo, LocalDate soldDate, double soldPrice, Store soldStore,
			Employee soldEmployee) {
		super();
		this.saleId = saleId;
		this.soldTo = soldTo;
		this.soldDate = soldDate;
		this.soldPrice = soldPrice;
		this.soldStore = soldStore;
		this.soldEmployee = soldEmployee;
	}
	/**
	 * @return the saleId
	 */
	public Long getSaleId() {
		return saleId;
	}
	/**
	 * @param saleId the saleId to set
	 */
	public void setSaleId(Long saleId) {
		this.saleId = saleId;
	}
	/**
	 * @return the soldTo
	 */
	public String getSoldTo() {
		return soldTo;
	}
	/**
	 * @param soldTo the soldTo to set
	 */
	public void setSoldTo(String soldTo) {
		this.soldTo = soldTo;
	}
	/**
	 * @return the soldDate
	 */
	public LocalDate getSoldDate() {
		return soldDate;
	}
	/**
	 * @param soldDate the soldDate to set
	 */
	public void setSoldDate(LocalDate soldDate) {
		this.soldDate = soldDate;
	}
	/**
	 * @return the soldPrice
	 */
	public double getSoldPrice() {
		return soldPrice;
	}
	/**
	 * @param soldPrice the soldPrice to set
	 */
	public void setSoldPrice(double soldPrice) {
		this.soldPrice = soldPrice;
	}
	/**
	 * @return the soldStore
	 */
	public Store getSoldStore() {
		return soldStore;
	}
	/**
	 * @param soldStore the soldStore to set
	 */
	public void setSoldStore(Store soldStore) {
		this.soldStore = soldStore;
	}
	/**
	 * @return the soldEmployee
	 */
	public Employee getSoldEmployee() {
		return soldEmployee;
	}
	/**
	 * @param soldEmployee the soldEmployee to set
	 */
	public void setSoldEmployee(Employee soldEmployee) {
		this.soldEmployee = soldEmployee;
	}

}
