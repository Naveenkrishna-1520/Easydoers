package com.easydoers.employeeservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.easydoers.employeeservice.dto.ClockinRequest;
import com.easydoers.employeeservice.dto.ClockinResponse;
import com.easydoers.employeeservice.entity.Employee;
import com.easydoers.employeeservice.service.EmployeeService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("v1/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@PostMapping("/saveEmployee")
	public ResponseEntity<String> saveEmployee(@RequestBody Employee employee) {
		Employee savedEmployee = employeeService.saveEmployee(employee);
		return ResponseEntity.ok("Employee '" + savedEmployee.getEmployeeNtid() + "' saved successfully!");
	}

	@PostMapping("/clockin")
	public ResponseEntity<ClockinResponse> saveClockInTimeForEmployee(@RequestBody ClockinRequest clockinRequest) {
		ClockinResponse saveClockInTimeForEmployee = employeeService
				.saveClockInTimeForEmployee(clockinRequest.getEmployeeNtid(), clockinRequest.getDealerStoreId());
		return ResponseEntity.ok(saveClockInTimeForEmployee);

	}

}
