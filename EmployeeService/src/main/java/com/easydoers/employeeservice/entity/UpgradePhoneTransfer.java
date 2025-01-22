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
	@JoinColumn(name = "store_id", nullable = false)
	private Store transferedStore;
	@ManyToOne
	@JoinColumn(name = "employee_id", nullable = false) 
	private Employee transferedEmployee;
	private String receivedEmployeeNtid;
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
	 * @param transferedEmployee
	 * @param receivedEmployeeNtid
	 */
	public UpgradePhoneTransfer(Long transferId, LocalDate transferDate, Store transferedStore,
			Employee transferedEmployee, String receivedEmployeeNtid) {
		super();
		this.transferId = transferId;
		this.transferDate = transferDate;
		this.transferedStore = transferedStore;
		this.transferedEmployee = transferedEmployee;
		this.receivedEmployeeNtid = receivedEmployeeNtid;
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
	 * @return the transferedEmployee
	 */
	public Employee getTransferedEmployee() {
		return transferedEmployee;
	}
	/**
	 * @param transferedEmployee the transferedEmployee to set
	 */
	public void setTransferedEmployee(Employee transferedEmployee) {
		this.transferedEmployee = transferedEmployee;
	}
	/**
	 * @return the receivedEmployeeNtid
	 */
	public String getReceivedEmployeeNtid() {
		return receivedEmployeeNtid;
	}
	/**
	 * @param receivedEmployeeNtid the receivedEmployeeNtid to set
	 */
	public void setReceivedEmployeeNtid(String receivedEmployeeNtid) {
		this.receivedEmployeeNtid = receivedEmployeeNtid;
	}
	
}
