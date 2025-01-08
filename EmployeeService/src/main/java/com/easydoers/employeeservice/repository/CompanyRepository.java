package com.easydoers.employeeservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.easydoers.employeeservice.entity.Company;

public interface CompanyRepository extends JpaRepository<Company, Integer>{

	Company findByCompanyName(String companyName);

}
