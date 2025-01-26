package com.easydoers.employeeservice.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.easydoers.employeeservice.dto.AuthorizedStoreAccessResponse;
import com.easydoers.employeeservice.dto.ClockinRequest;
import com.easydoers.employeeservice.dto.ClockinResponse;
import com.easydoers.employeeservice.entity.Employee;
import com.easydoers.employeeservice.service.EmployeeService;

@RestController
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
	
	@GetMapping("/authorizedStores/{employeeNtid}")
	public ResponseEntity<AuthorizedStoreAccessResponse> getAuthorizedStores(@PathVariable String employeeNtid){
		AuthorizedStoreAccessResponse response = employeeService.getAuthorizedStores(employeeNtid);
		return new ResponseEntity<AuthorizedStoreAccessResponse>(response, HttpStatus.OK);
	}

}
