package com.easydoers.employeeservice.entity;

import java.time.YearMonth;

import com.easydoers.employeeservice.converter.YearMonthConverter;
import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
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
	private int hsiTarget;
	private int tabletsTargetByEmployee;
	private int smartwatchTragetByEmployee;
	@Column(nullable = false, length = 7) // Store as "YYYY-MM"
	@Convert(converter = YearMonthConverter.class)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM")
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
	public EmployeeTarget(int targetId, int phonesTargetToEmployee, double accessoriesTargetByEmployee, int hsiTarget,
			int tabletsTargetByEmployee, int smartwatchTragetByEmployee, YearMonth targetMonth, Employee employee) {
		super();
		this.targetId = targetId;
		this.phonesTargetToEmployee = phonesTargetToEmployee;
		this.accessoriesTargetByEmployee = accessoriesTargetByEmployee;
		this.hsiTarget = hsiTarget;
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
	 * @return the hsiTarget
	 */
	public int getHsiTarget() {
		return hsiTarget;
	}

	/**
	 * @param hsiTarget the hsiTarget to set
	 */
	public void setHsiTarget(int hsiTarget) {
		this.hsiTarget = hsiTarget;
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

}
