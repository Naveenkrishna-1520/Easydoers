package com.easydoers.employeeservice.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class UpgradePhonesInvoice {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long invoiceId;
	private Long accountNumber;
	private LocalDate activatedDate;
	private double amount;
	@ManyToOne
	@JoinColumn(name = "store_id", nullable = false)
	private Store store;
	@ManyToOne
	@JoinColumn(name = "employee_id", nullable = false) 
	private Employee employee;
	/**
	 * 
	 */
	public UpgradePhonesInvoice() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param invoiceId
	 * @param accountNumber
	 * @param activatedDate
	 * @param amount
	 * @param store
	 * @param employee
	 */
	public UpgradePhonesInvoice(Long invoiceId, Long accountNumber, LocalDate activatedDate, double amount, Store store,
			Employee employee) {
		super();
		this.invoiceId = invoiceId;
		this.accountNumber = accountNumber;
		this.activatedDate = activatedDate;
		this.amount = amount;
		this.store = store;
		this.employee = employee;
	}
	/**
	 * @return the invoiceId
	 */
	public Long getInvoiceId() {
		return invoiceId;
	}
	/**
	 * @param invoiceId the invoiceId to set
	 */
	public void setInvoiceId(Long invoiceId) {
		this.invoiceId = invoiceId;
	}
	/**
	 * @return the accountNumber
	 */
	public Long getAccountNumber() {
		return accountNumber;
	}
	/**
	 * @param accountNumber the accountNumber to set
	 */
	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}
	/**
	 * @return the activatedDate
	 */
	public LocalDate getActivatedDate() {
		return activatedDate;
	}
	/**
	 * @param activatedDate the activatedDate to set
	 */
	public void setActivatedDate(LocalDate activatedDate) {
		this.activatedDate = activatedDate;
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
	
}
