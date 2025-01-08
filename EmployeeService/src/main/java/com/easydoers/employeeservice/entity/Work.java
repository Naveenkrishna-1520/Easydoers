package com.easydoers.employeeservice.entity;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Work {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long workId;
	@ManyToOne
    @JoinColumn(name = "employee_id", nullable = true)
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "store_id", nullable = true)
    private Store store;
    private LocalTime clockInTime;
    private LocalTime clockOutTime;
    private LocalDate date;
	private Double numberOfHoursWorkedByEmployee;

	/**
	 * 
	 */
	public Work() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param workId
	 * @param employee
	 * @param store
	 * @param clockInTime
	 * @param clockOutTime
	 * @param date
	 * @param numberOfHoursWorkedByEmployee
	 */
	public Work(Long workId, Employee employee, Store store, LocalTime clockInTime, LocalTime clockOutTime,
			LocalDate date, Double numberOfHoursWorkedByEmployee) {
		super();
		this.workId = workId;
		this.employee = employee;
		this.store = store;
		this.clockInTime = clockInTime;
		this.clockOutTime = clockOutTime;
		this.date = date;
		this.numberOfHoursWorkedByEmployee = numberOfHoursWorkedByEmployee;
	}

	/**
	 * @return the workId
	 */
	public Long getWorkId() {
		return workId;
	}

	/**
	 * @param workId the workId to set
	 */
	public void setWorkId(Long workId) {
		this.workId = workId;
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
	 * @return the clockInTime
	 */
	public LocalTime getClockInTime() {
		return clockInTime;
	}

	/**
	 * @param clockInTime the clockInTime to set
	 */
	public void setClockInTime(LocalTime clockInTime) {
		this.clockInTime = clockInTime;
	}

	/**
	 * @return the clockOutTime
	 */
	public LocalTime getClockOutTime() {
		return clockOutTime;
	}

	/**
	 * @param clockOutTime the clockOutTime to set
	 */
	public void setClockOutTime(LocalTime clockOutTime) {
		this.clockOutTime = clockOutTime;
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
	 * @return the numberOfHoursWorkedByEmployee
	 */
	public Double getNumberOfHoursWorkedByEmployee() {
		return numberOfHoursWorkedByEmployee;
	}

	/**
	 * @param numberOfHoursWorkedByEmployee the numberOfHoursWorkedByEmployee to set
	 */
	public void setNumberOfHoursWorkedByEmployee(Double numberOfHoursWorkedByEmployee) {
		this.numberOfHoursWorkedByEmployee = numberOfHoursWorkedByEmployee;
	}

	@Override
	public String toString() {
		return "Work [workId=" + workId + ", employee=" + employee + ", store=" + store + ", clockInTime=" + clockInTime
				+ ", clockOutTime=" + clockOutTime + ", date=" + date + ", numberOfHoursWorkedByEmployee="
				+ numberOfHoursWorkedByEmployee + "]";
	}

	
	
}
