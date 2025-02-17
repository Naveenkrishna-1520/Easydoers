package com.easydoers.employeeservice.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.easydoers.employeeservice.dto.CompanyResponse;
import com.easydoers.employeeservice.dto.StoreResponse;
import com.easydoers.employeeservice.entity.Company;
import com.easydoers.employeeservice.service.CompanyService;
import com.easydoers.employeeservice.service.InvoiceService;
import com.easydoers.employeeservice.service.StoreService;

@RestController
@RequestMapping("v1/admin")
public class AdminController {

	
	@Autowired
	private CompanyService companyService;
	@Autowired
	private InvoiceService invoiceService;
	@Autowired
	private StoreService storeService;
	
	@PostMapping("/companyRegistration")
	public ResponseEntity<String> createCompany(@RequestBody Company company){
		String message = companyService.createCompany(company);
		return new ResponseEntity<String>(message, HttpStatus.OK);
	}
	
	@GetMapping("/viewAllCompanies")
	public ResponseEntity<CompanyResponse> fetchAllCompanies(){
		CompanyResponse companies = companyService.fetchCompanies();
		return new ResponseEntity<CompanyResponse>(companies, HttpStatus.OK);
	}
	
	@GetMapping("/viewAllStoresUnderTheCompany/{companyName}")
	public ResponseEntity<StoreResponse> fetchAllStores(@PathVariable String companyName){
		StoreResponse stores = companyService.fetchStores(companyName);
		return new ResponseEntity<StoreResponse>(stores, HttpStatus.OK);
		
	}
	
	@PostMapping("/generateInvoices")
	public ResponseEntity<String> generateInvoices(){
		String message = invoiceService.generateInvoicesForAllCompanies();
		return new ResponseEntity<String>(message,HttpStatus.OK);
		
	}
	
	@DeleteMapping("/deleteStore")
	public ResponseEntity<String> deleteStore(@RequestParam String dealerStoreId){
		String message = storeService.deleteStore(dealerStoreId);
		return new ResponseEntity<String>(message,HttpStatus.OK);
	}
}
