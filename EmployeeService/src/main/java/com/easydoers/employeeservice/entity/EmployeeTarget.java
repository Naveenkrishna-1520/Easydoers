package com.easydoers.employeeservice.entity;

import java.time.YearMonth;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class EmployeeTarget {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int targetId;
	private int phonesTargetToEmployee;
	private double accessoriesTargetByEmployee;
	private int HSITarget;
	private int tabletsTargetByEmployee;
	private int smartwatchTragetByEmployee;
	private YearMonth targetMonth;

	@ManyToOne
	@JoinColumn(name = "employee_id")
	private Employee employee;

	/**
	 * 
	 */
	public EmployeeTarget() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param targetId
	 * @param phonesTargetToEmployee
	 * @param accessoriesTargetByEmployee
	 * @param hSITarget
	 * @param tabletsTargetByEmployee
	 * @param smartwatchTragetByEmployee
	 * @param targetMonth
	 * @param employee
	 */
	public EmployeeTarget(int targetId, int phonesTargetToEmployee, double accessoriesTargetByEmployee, int hSITarget,
			int tabletsTargetByEmployee, int smartwatchTragetByEmployee, YearMonth targetMonth, Employee employee) {
		super();
		this.targetId = targetId;
		this.phonesTargetToEmployee = phonesTargetToEmployee;
		this.accessoriesTargetByEmployee = accessoriesTargetByEmployee;
		HSITarget = hSITarget;
		this.tabletsTargetByEmployee = tabletsTargetByEmployee;
		this.smartwatchTragetByEmployee = smartwatchTragetByEmployee;
		this.targetMonth = targetMonth;
		this.employee = employee;
	}

	/**
	 * @return the targetId
	 */
	public int getTargetId() {
		return targetId;
	}

	/**
	 * @param targetId the targetId to set
	 */
	public void setTargetId(int targetId) {
		this.targetId = targetId;
	}

	/**
	 * @return the phonesTargetToEmployee
	 */
	public int getPhonesTargetToEmployee() {
		return phonesTargetToEmployee;
	}

	/**
	 * @param phonesTargetToEmployee the phonesTargetToEmployee to set
	 */
	public void setPhonesTargetToEmployee(int phonesTargetToEmployee) {
		this.phonesTargetToEmployee = phonesTargetToEmployee;
	}

	/**
	 * @return the accessoriesTargetByEmployee
	 */
	public double getAccessoriesTargetByEmployee() {
		return accessoriesTargetByEmployee;
	}

	/**
	 * @param accessoriesTargetByEmployee the accessoriesTargetByEmployee to set
	 */
	public void setAccessoriesTargetByEmployee(double accessoriesTargetByEmployee) {
		this.accessoriesTargetByEmployee = accessoriesTargetByEmployee;
	}

	/**
	 * @return the hSITarget
	 */
	public int getHSITarget() {
		return HSITarget;
	}

	/**
	 * @param hSITarget the hSITarget to set
	 */
	public void setHSITarget(int hSITarget) {
		HSITarget = hSITarget;
	}

	/**
	 * @return the tabletsTargetByEmployee
	 */
	public int getTabletsTargetByEmployee() {
		return tabletsTargetByEmployee;
	}

	/**
	 * @param tabletsTargetByEmployee the tabletsTargetByEmployee to set
	 */
	public void setTabletsTargetByEmployee(int tabletsTargetByEmployee) {
		this.tabletsTargetByEmployee = tabletsTargetByEmployee;
	}

	/**
	 * @return the smartwatchTragetByEmployee
	 */
	public int getSmartwatchTragetByEmployee() {
		return smartwatchTragetByEmployee;
	}

	/**
	 * @param smartwatchTragetByEmployee the smartwatchTragetByEmployee to set
	 */
	public void setSmartwatchTragetByEmployee(int smartwatchTragetByEmployee) {
		this.smartwatchTragetByEmployee = smartwatchTragetByEmployee;
	}

	/**
	 * @return the targetMonth
	 */
	public YearMonth getTargetMonth() {
		return targetMonth;
	}

	/**
	 * @param targetMonth the targetMonth to set
	 */
	public void setTargetMonth(YearMonth targetMonth) {
		this.targetMonth = targetMonth;
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

	@Override
	public String toString() {
		return "EmployeeTarget [targetId=" + targetId + ", phonesTargetToEmployee=" + phonesTargetToEmployee
				+ ", accessoriesTargetByEmployee=" + accessoriesTargetByEmployee + ", HSITarget=" + HSITarget
				+ ", tabletsTargetByEmployee=" + tabletsTargetByEmployee + ", smartwatchTragetByEmployee="
				+ smartwatchTragetByEmployee + ", targetMonth=" + targetMonth + ", employee=" + employee + "]";
	}

	

}
