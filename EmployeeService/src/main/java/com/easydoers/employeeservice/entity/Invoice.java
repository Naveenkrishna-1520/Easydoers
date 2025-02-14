package com.easydoers.employeeservice.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PostPersist;

@Entity
public class Invoice {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; 
    private String invoiceId;  // Custom formatted Invoice ID
    private LocalDate date;
    private Double amount;
    @ManyToOne
	@JoinColumn(name = "store_id")
	private Store store;

    @PostPersist
    public void generateInvoiceId() {
        this.invoiceId = "INV-00" + this.id;
    }

	/**
	 * 
	 */
	public Invoice() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param invoiceId
	 * @param date
	 * @param amount
	 * @param store
	 */
	public Invoice(Long id, String invoiceId, LocalDate date, Double amount, Store store) {
		super();
		this.id = id;
		this.invoiceId = invoiceId;
		this.date = date;
		this.amount = amount;
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
	 * @return the invoiceId
	 */
	public String getInvoiceId() {
		return invoiceId;
	}

	/**
	 * @param invoiceId the invoiceId to set
	 */
	public void setInvoiceId(String invoiceId) {
		this.invoiceId = invoiceId;
	}

	/**
	 * @return the date
	 */
	public LocalDate getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(LocalDate date) {
		this.date = date;
	}

	/**
	 * @return the amount
	 */
	public Double getAmount() {
		return amount;
	}

	/**
	 * @param amount the amount to set
	 */
	public void setAmount(Double amount) {
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

	
}
