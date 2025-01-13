package com.easydoers.employeeservice.dto;

public class LogInResponse {
	
	private EmployeeDTO employeeDTO;
	private StoreDTO storeDTO;
	
	/**
	 * 
	 */
	public LogInResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param employeeDTO
	 * @param storeDTO
	 */
	public LogInResponse(EmployeeDTO employeeDTO, StoreDTO storeDTO) {
		super();
		this.employeeDTO = employeeDTO;
		this.storeDTO = storeDTO;
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

	/**
	 * @return the storeDTO
	 */
	public StoreDTO getStoreDTO() {
		return storeDTO;
	}

	/**
	 * @param storeDTO the storeDTO to set
	 */
	public void setStoreDTO(StoreDTO storeDTO) {
		this.storeDTO = storeDTO;
	}

	@Override
	public String toString() {
		return "LogInResponse [employee=" + employeeDTO + ", store=" + storeDTO + "]";
	}
	

}


