package com.easydoers.employeeservice.dto;


public class CompanyDTO {
	
	private Long companyId;
	private String companyName;
	/**
	 * 
	 */
	public CompanyDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param companyId
	 * @param companyName
	 */
	public CompanyDTO(Long companyId, String companyName) {
		super();
		this.companyId = companyId;
		this.companyName = companyName;
	}
	/**
	 * @return the companyId
	 */
	public Long getCompanyId() {
		return companyId;
	}
	/**
	 * @param companyId the companyId to set
	 */
	public void setCompanyId(Long companyId) {
		this.companyId = companyId;
	}
	/**
	 * @return the companyName
	 */
	public String getCompanyName() {
		return companyName;
	}
	/**
	 * @param companyName the companyName to set
	 */
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

}
