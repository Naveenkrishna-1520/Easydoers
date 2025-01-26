package com.easydoers.employeeservice.dto;

public class InvoiceDetailsResponse {
	
	private String customerAccountNumber;
	private String invoicedStore;
	private String invoicedEmployee;
	private String invoicedDate;
	private double invoicedAmount;
	/**
	 * @return the customerAccountNumber
	 */
	public String getCustomerAccountNumber() {
		return customerAccountNumber;
	}
	/**
	 * @param customerAccountNumber the customerAccountNumber to set
	 */
	public void setCustomerAccountNumber(String customerAccountNumber) {
		this.customerAccountNumber = customerAccountNumber;
	}
	/**
	 * @return the invoicedStore
	 */
	public String getInvoicedStore() {
		return invoicedStore;
	}
	/**
	 * @param invoicedStore the invoicedStore to set
	 */
	public void setInvoicedStore(String invoicedStore) {
		this.invoicedStore = invoicedStore;
	}
	/**
	 * @return the invoicedEmployee
	 */
	public String getInvoicedEmployee() {
		return invoicedEmployee;
	}
	/**
	 * @param invoicedEmployee the invoicedEmployee to set
	 */
	public void setInvoicedEmployee(String invoicedEmployee) {
		this.invoicedEmployee = invoicedEmployee;
	}
	/**
	 * @return the invoicedDate
	 */
	public String getInvoicedDate() {
		return invoicedDate;
	}
	/**
	 * @param invoicedDate the invoicedDate to set
	 */
	public void setInvoicedDate(String invoicedDate) {
		this.invoicedDate = invoicedDate;
	}
	/**
	 * @return the invoicedAmount
	 */
	public double getInvoicedAmount() {
		return invoicedAmount;
	}
	/**
	 * @param invoicedAmount the invoicedAmount to set
	 */
	public void setInvoicedAmount(double invoicedAmount) {
		this.invoicedAmount = invoicedAmount;
	}
}
