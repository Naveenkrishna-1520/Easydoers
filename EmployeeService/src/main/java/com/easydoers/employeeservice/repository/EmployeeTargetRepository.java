package com.easydoers.employeeservice.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.easydoers.employeeservice.entity.EmployeeTarget;

@Repository
public interface EmployeeTargetRepository extends JpaRepository<EmployeeTarget, Integer> {

    
}
