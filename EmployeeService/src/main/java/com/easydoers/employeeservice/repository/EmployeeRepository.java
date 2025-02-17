package com.easydoers.employeeservice.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.easydoers.employeeservice.entity.Company;
import com.easydoers.employeeservice.entity.Employee;
import com.easydoers.employeeservice.entity.Manager;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{
	
	Employee findByEmployeeNtid(String employeeNtid);

	List<Employee> findByCompanyAndIsActiveTrue(Company company);

	List<Employee> findByManagerAndIsActiveTrue(Manager manager);


}
