package com.easydoers.employeeservice.service;




import com.easydoers.employeeservice.dto.AuthorizedStoreAccessResponse;
import com.easydoers.employeeservice.dto.ClockinResponse;
import com.easydoers.employeeservice.dto.LogInRequest;
import com.easydoers.employeeservice.entity.Employee;

public interface EmployeeService {
	
	
	Employee saveEmployee(Employee employee);
	String validateUser(LogInRequest logInRequest);
	Employee checkEmployee(String employeeNTId);
	ClockinResponse saveClockInTimeForEmployee(String employeeNtid, String dealerStoreId);
	AuthorizedStoreAccessResponse getAuthorizedStores(String employeeNtid);
	

}
