package com.easydoers.employeeservice.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class UpgradePhoneReceive {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long receive_Id;
	private LocalDate receiveDate;
	@ManyToOne
	@JoinColumn(name = "store_id", nullable = false)
	private Store transferedStore;
	@ManyToOne
	@JoinColumn(name = "employee_id", nullable = false) 
	private Employee transferedEmployee;
	/**
	 * 
	 */
	public UpgradePhoneReceive() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param receive_Id
	 * @param receiveDate
	 * @param transferedStore
	 * @param transferedEmployee
	 */
	public UpgradePhoneReceive(Long receive_Id, LocalDate receiveDate, Store transferedStore,
			Employee transferedEmployee) {
		super();
		this.receive_Id = receive_Id;
		this.receiveDate = receiveDate;
		this.transferedStore = transferedStore;
		this.transferedEmployee = transferedEmployee;
	}
	/**
	 * @return the receive_Id
	 */
	public Long getReceive_Id() {
		return receive_Id;
	}
	/**
	 * @param receive_Id the receive_Id to set
	 */
	public void setReceive_Id(Long receive_Id) {
		this.receive_Id = receive_Id;
	}
	/**
	 * @return the receiveDate
	 */
	public LocalDate getReceiveDate() {
		return receiveDate;
	}
	/**
	 * @param receiveDate the receiveDate to set
	 */
	public void setReceiveDate(LocalDate receiveDate) {
		this.receiveDate = receiveDate;
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
}
