package com.easydoers.employeeservice.service;

import java.util.List;

import com.easydoers.employeeservice.dto.EmployeeTargetResponse;
import com.easydoers.employeeservice.entity.EmployeeTarget;

public interface EmployeeTargetService {

	String setEmployeeTarget(EmployeeTarget employeeTarget);

	List<EmployeeTargetResponse> getAllEmployeeTargets(String companyName, String targetMonth);

}
