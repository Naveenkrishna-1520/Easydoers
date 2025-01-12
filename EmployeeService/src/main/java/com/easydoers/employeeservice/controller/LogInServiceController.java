package com.easydoers.employeeservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.easydoers.employeeservice.dto.LogInRequest;
import com.easydoers.employeeservice.service.EmployeeService;

@RestController
@RequestMapping("v1/authentication")
public class LogInServiceController {
	
	
	@Autowired
	private EmployeeService employeeService;
    
    
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LogInRequest logInRequest) {
    	String checkUser = employeeService.validateUser(logInRequest);
		return ResponseEntity.ok(checkUser);
    	
    }

}
