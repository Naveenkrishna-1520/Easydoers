package com.easydoers.employeeservice.service;



import com.easydoers.employeeservice.entity.Company;

public interface CompanyService {

	Company getCompany(int companyId);

	String createCompany(Company company);


}
