package com.easydoers.employeeservice.service.implementation;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.easydoers.employeeservice.entity.Company;
import com.easydoers.employeeservice.repository.CompanyRepository;
import com.easydoers.employeeservice.service.CompanyService;


@Service
public class CompanyServiceImplementation implements CompanyService{
	
	@Autowired
	private CompanyRepository companyRepository;

	@Override
	public Company getCompany(int companyId) {
		Company company = companyRepository.findBycompanyId(companyId);
		return company;
	}

}
