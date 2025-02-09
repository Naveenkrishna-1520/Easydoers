package com.easydoers.employeeservice.dto;

import java.util.List;

public class CompanyResponse {
	
	private List<CompanyDTO> companies;

	/**
	 * @return the companies
	 */
	public List<CompanyDTO> getCompanies() {
		return companies;
	}

	/**
	 * @param companies the companies to set
	 */
	public void setCompanies(List<CompanyDTO> companies) {
		this.companies = companies;
	}

}
