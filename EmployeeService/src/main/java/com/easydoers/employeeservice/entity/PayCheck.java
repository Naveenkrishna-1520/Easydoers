package com.easydoers.employeeservice.entity;

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
	 */
	public PayCheck(Long payCheckId, Employee employee, double boxesCommission, double accessoriesCommission,
			double totalEarnedByEmployee) {
		super();
		this.payCheckId = payCheckId;
		this.employee = employee;
		this.boxesCommission = boxesCommission;
		this.accessoriesCommission = accessoriesCommission;
		this.totalEarnedByEmployee = totalEarnedByEmployee;
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

	@Override
	public String toString() {
		return "PayCheck [payCheckId=" + payCheckId + ", employee=" + employee + ", boxesCommission=" + boxesCommission
				+ ", accessoriesCommission=" + accessoriesCommission + ", totalEarnedByEmployee="
				+ totalEarnedByEmployee + "]";
	}

}
