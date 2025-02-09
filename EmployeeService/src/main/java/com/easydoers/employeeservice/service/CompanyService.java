package com.easydoers.employeeservice.service;


import com.easydoers.employeeservice.dto.CompanyResponse;
import com.easydoers.employeeservice.dto.StoreResponse;
import com.easydoers.employeeservice.entity.Company;

public interface CompanyService {

	Company getCompany(long companyId);

	String createCompany(Company company);

	CompanyResponse fetchCompanies();

	StoreResponse fetchStores(String companyName);

	Company checkCompany(String companyName);


}
