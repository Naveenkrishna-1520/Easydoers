package com.easydoers.employeeservice.dto;



public class EmployeeTargetResponse {

	private int targetId;
	private int phonesTargetToEmployee;
	private double accessoriesTargetByEmployee;
	private int hsiTarget;
	private int tabletsTargetByEmployee;
	private int smartwatchTragetByEmployee;
	private String targetMonth;
	private EmployeeDTO employeeDTO;

	/**
	 * @param targetId
	 * @param phonesTargetToEmployee
	 * @param accessoriesTargetByEmployee
	 * @param hsiTarget
	 * @param tabletsTargetByEmployee
	 * @param smartwatchTragetByEmployee
	 * @param targetMonth
	 * @param employeeDTO
	 */
	public EmployeeTargetResponse(int targetId, int phonesTargetToEmployee, double accessoriesTargetByEmployee,
			int hsiTarget, int tabletsTargetByEmployee, int smartwatchTragetByEmployee, String targetMonth,
			EmployeeDTO employeeDTO) {
		super();
		this.targetId = targetId;
		this.phonesTargetToEmployee = phonesTargetToEmployee;
		this.accessoriesTargetByEmployee = accessoriesTargetByEmployee;
		this.hsiTarget = hsiTarget;
		this.tabletsTargetByEmployee = tabletsTargetByEmployee;
		this.smartwatchTragetByEmployee = smartwatchTragetByEmployee;
		this.targetMonth = targetMonth;
		this.employeeDTO = employeeDTO;
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
	public String getTargetMonth() {
		return targetMonth;
	}

	/**
	 * @param targetMonth the targetMonth to set
	 */
	public void setTargetMonth(String targetMonth) {
		this.targetMonth = targetMonth;
	}

	/**
	 * @return the employeeDTO
	 */
	public EmployeeDTO getEmployeeDTO() {
		return employeeDTO;
	}

	/**
	 * @param employeeDTO the employeeDTO to set
	 */
	public void setEmployeeDTO(EmployeeDTO employeeDTO) {
		this.employeeDTO = employeeDTO;
	}

}
