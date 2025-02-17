package com.easydoers.employeeservice.service;




import java.util.List;

import com.easydoers.employeeservice.dto.AuthorizedStoreAccessResponse;
import com.easydoers.employeeservice.dto.ClockinResponse;
import com.easydoers.employeeservice.dto.EmployeeDetailsDTO;
import com.easydoers.employeeservice.entity.Company;
import com.easydoers.employeeservice.entity.Employee;

public interface EmployeeService {
	
	
	Employee saveEmployee(Employee employee);
	Employee checkEmployee(String employeeNTId);
	ClockinResponse saveClockInTimeForEmployee(String employeeNtid, String dealerStoreId);
	AuthorizedStoreAccessResponse getAuthorizedStores(String employeeNtid);
	String assignManagerToEmployee(String employeeNtid, String managerName);
	List<Employee> getEmployeesUnderCompany(Company company);
	String deleteEmployee(String employeeNtid);
	EmployeeDetailsDTO updateEmployee(Employee employee);
	Employee isEmployeeAvailable(String employeeNTId);
	

}
