package com.easydoers.employeeservice.entity;

import java.time.LocalDate;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class PayCheck {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long payCheckId;
	@ManyToOne
	@JoinColumn(name = "employee_id", nullable = true)
	private Employee employee;
	private double boxesCommission;
	private double accessoriesCommission;
	private double totalEarnedByEmployee;
	private LocalDate payCheckStartDate;
	private LocalDate payCheckEndDate;
	private int month;
	private int year;
	private LocalDate payGeneratedDate;

	/**
	 * 
	 */
	public PayCheck() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param payCheckId
	 * @param employee
	 * @param boxesCommission
	 * @param accessoriesCommission
	 * @param totalEarnedByEmployee
	 * @param payCheckStartDate
	 * @param payCheckEndDate
	 * @param month
	 * @param year
	 * @param payGeneratedDate
	 */
	public PayCheck(Long payCheckId, Employee employee, double boxesCommission, double accessoriesCommission,
			double totalEarnedByEmployee, LocalDate payCheckStartDate, LocalDate payCheckEndDate, int month, int year,
			LocalDate payGeneratedDate) {
		super();
		this.payCheckId = payCheckId;
		this.employee = employee;
		this.boxesCommission = boxesCommission;
		this.accessoriesCommission = accessoriesCommission;
		this.totalEarnedByEmployee = totalEarnedByEmployee;
		this.payCheckStartDate = payCheckStartDate;
		this.payCheckEndDate = payCheckEndDate;
		this.month = month;
		this.year = year;
		this.payGeneratedDate = payGeneratedDate;
	}

	/**
	 * @return the payCheckId
	 */
	public Long getPayCheckId() {
		return payCheckId;
	}

	/**
	 * @param payCheckId the payCheckId to set
	 */
	public void setPayCheckId(Long payCheckId) {
		this.payCheckId = payCheckId;
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

	/**
	 * @return the boxesCommission
	 */
	public double getBoxesCommission() {
		return boxesCommission;
	}

	/**
	 * @param boxesCommission the boxesCommission to set
	 */
	public void setBoxesCommission(double boxesCommission) {
		this.boxesCommission = boxesCommission;
	}

	/**
	 * @return the accessoriesCommission
	 */
	public double getAccessoriesCommission() {
		return accessoriesCommission;
	}

	/**
	 * @param accessoriesCommission the accessoriesCommission to set
	 */
	public void setAccessoriesCommission(double accessoriesCommission) {
		this.accessoriesCommission = accessoriesCommission;
	}

	/**
	 * @return the totalEarnedByEmployee
	 */
	public double getTotalEarnedByEmployee() {
		return totalEarnedByEmployee;
	}

	/**
	 * @param totalEarnedByEmployee the totalEarnedByEmployee to set
	 */
	public void setTotalEarnedByEmployee(double totalEarnedByEmployee) {
		this.totalEarnedByEmployee = totalEarnedByEmployee;
	}

	/**
	 * @return the payCheckStartDate
	 */
	public LocalDate getPayCheckStartDate() {
		return payCheckStartDate;
	}

	/**
	 * @param payCheckStartDate the payCheckStartDate to set
	 */
	public void setPayCheckStartDate(LocalDate payCheckStartDate) {
		this.payCheckStartDate = payCheckStartDate;
	}

	/**
	 * @return the payCheckEndDate
	 */
	public LocalDate getPayCheckEndDate() {
		return payCheckEndDate;
	}

	/**
	 * @param payCheckEndDate the payCheckEndDate to set
	 */
	public void setPayCheckEndDate(LocalDate payCheckEndDate) {
		this.payCheckEndDate = payCheckEndDate;
	}

	/**
	 * @return the month
	 */
	public int getMonth() {
		return month;
	}

	/**
	 * @param month the month to set
	 */
	public void setMonth(int month) {
		this.month = month;
	}

	/**
	 * @return the year
	 */
	public int getYear() {
		return year;
	}

	/**
	 * @param year the year to set
	 */
	public void setYear(int year) {
		this.year = year;
	}

	/**
	 * @return the payGeneratedDate
	 */
	public LocalDate getPayGeneratedDate() {
		return payGeneratedDate;
	}

	/**
	 * @param payGeneratedDate the payGeneratedDate to set
	 */
	public void setPayGeneratedDate(LocalDate payGeneratedDate) {
		this.payGeneratedDate = payGeneratedDate;
	}

}
