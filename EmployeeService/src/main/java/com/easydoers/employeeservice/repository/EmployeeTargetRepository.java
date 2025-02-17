package com.easydoers.employeeservice.repository;


import java.time.YearMonth;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.easydoers.employeeservice.entity.Employee;
import com.easydoers.employeeservice.entity.EmployeeTarget;

@Repository
public interface EmployeeTargetRepository extends JpaRepository<EmployeeTarget, Integer> {

	EmployeeTarget findByEmployeeAndTargetMonth(Employee employee, YearMonth targetMonth);

	EmployeeTarget findByEmployeeAndTargetMonth(Employee employee, String targetMonth);

    
}
