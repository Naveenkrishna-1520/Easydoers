package com.easydoers.employeeservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.easydoers.employeeservice.entity.Employee;
import com.easydoers.employeeservice.entity.PayCheck;


@Repository
public interface PayCheckRepository extends JpaRepository<PayCheck, Long>{

	List<PayCheck> findByEmployeeAndMonthAndYear(Employee employee, int month, int year);

}
