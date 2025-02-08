package com.easydoers.employeeservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.easydoers.employeeservice.entity.Company;
import com.easydoers.employeeservice.service.CompanyService;

@RestController
@RequestMapping("v1/company")
public class CompanyController {
	
	@Autowired
	private CompanyService companyService;
	
	@PostMapping("/registration")
	public ResponseEntity<String> createCompany(@RequestBody Company company){
		String message = companyService.createCompany(company);
		return new ResponseEntity<String>(message, HttpStatus.OK);
	}

}
