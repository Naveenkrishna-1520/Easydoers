package com.easydoers.employeeservice.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class UpgradePhoneTransfer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long transferId;
	private LocalDate transferDate;
	@ManyToOne
	@JoinColumn(name = "transferred_to", nullable = false)
	private Store transferedStore;
	@ManyToOne
	@JoinColumn(name = "transferred_by", nullable = false) 
	private Employee transferredEmployee;
	/**
	 * 
	 */
	public UpgradePhoneTransfer() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param transferId
	 * @param transferDate
	 * @param transferedStore
	 * @param transferredEmployee
	 */
	public UpgradePhoneTransfer(Long transferId, LocalDate transferDate, Store transferedStore,
			Employee transferredEmployee) {
		super();
		this.transferId = transferId;
		this.transferDate = transferDate;
		this.transferedStore = transferedStore;
		this.transferredEmployee = transferredEmployee;
	}
	/**
	 * @return the transferId
	 */
	public Long getTransferId() {
		return transferId;
	}
	/**
	 * @param transferId the transferId to set
	 */
	public void setTransferId(Long transferId) {
		this.transferId = transferId;
	}
	/**
	 * @return the transferDate
	 */
	public LocalDate getTransferDate() {
		return transferDate;
	}
	/**
	 * @param transferDate the transferDate to set
	 */
	public void setTransferDate(LocalDate transferDate) {
		this.transferDate = transferDate;
	}
	/**
	 * @return the transferedStore
	 */
	public Store getTransferedStore() {
		return transferedStore;
	}
	/**
	 * @param transferedStore the transferedStore to set
	 */
	public void setTransferedStore(Store transferedStore) {
		this.transferedStore = transferedStore;
	}
	/**
	 * @return the transferredEmployee
	 */
	public Employee getTransferredEmployee() {
		return transferredEmployee;
	}
	/**
	 * @param transferredEmployee the transferredEmployee to set
	 */
	public void setTransferredEmployee(Employee transferredEmployee) {
		this.transferredEmployee = transferredEmployee;
	}
}
