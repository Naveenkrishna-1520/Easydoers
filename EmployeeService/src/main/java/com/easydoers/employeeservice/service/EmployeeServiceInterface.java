package com.easydoers.employeeservice.service;

import com.easydoers.employeeservice.dto.EmployeeSalesDTO;
import com.easydoers.employeeservice.dto.SaleRequest;
import com.easydoers.employeeservice.entity.Employee;

public interface EmployeeServiceInterface {
	
	
	Employee saveEmployee(Employee employee);
	String saveSaleDetails(String employeeNTId, String dealerStoreId,SaleRequest saleRequest);
	EmployeeSalesDTO getEmployeeSales(String employeeNtid);
	String saveClockInTimeForEmployee(String employeeNtid, String delaerStoreId);
	

}
