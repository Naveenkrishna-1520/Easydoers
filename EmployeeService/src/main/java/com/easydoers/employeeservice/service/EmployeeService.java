package com.easydoers.employeeservice.service;

import com.easydoers.employeeservice.dto.EmployeeSalesDTO;
import com.easydoers.employeeservice.dto.LogInRequest;
import com.easydoers.employeeservice.dto.SaleRequest;
import com.easydoers.employeeservice.entity.Employee;

public interface EmployeeService {
	
	
	Employee saveEmployee(Employee employee);
	String saveSaleDetails(String employeeNTId, String dealerStoreId,SaleRequest saleRequest);
	EmployeeSalesDTO getEmployeeSales(String employeeNtid);
	String saveClockInTimeForEmployee(String employeeNtid, String delaerStoreId);
	String getSerialNumber();
	String validateUser(LogInRequest logInRequest);
	String loginUser(LogInRequest logInRequest);
	

}
