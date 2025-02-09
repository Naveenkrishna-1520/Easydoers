package com.easydoers.employeeservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.easydoers.employeeservice.entity.Compensation;
import com.easydoers.employeeservice.entity.Manager;
import com.easydoers.employeeservice.entity.Store;
import com.easydoers.employeeservice.service.CompensationService;
import com.easydoers.employeeservice.service.ManagerService;
import com.easydoers.employeeservice.service.StoreService;

@RestController
@RequestMapping("v1/company")
public class CompanyController {
	
	
	@Autowired
	private ManagerService managerService;
	@Autowired
	private StoreService storeService;
	@Autowired
	private CompensationService  compensationService;

	@PostMapping("/managerRegistration")
	public ResponseEntity<String> createManager(@RequestBody Manager manager) {

		String message = managerService.createManager(manager);
		return new ResponseEntity<String>(message, HttpStatus.OK);

	}

	@PostMapping("/storeRegistration")
	public ResponseEntity<String> addStoreUnderThisCompany(@RequestBody Store store) {
		
		String message = storeService.createStore(store);
		return new ResponseEntity<String>(message, HttpStatus.OK);

	}
	
	@PostMapping("/recordCompensation")
	public ResponseEntity<String> recordCompensation(@RequestBody Compensation compensation){
		
		String message = compensationService.saveCompensation(compensation);
		return new ResponseEntity<String>(message, HttpStatus.OK);
		
	}

}
