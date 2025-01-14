package com.easydoers.employeeservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.easydoers.employeeservice.dto.EmployeeSalesDTO;
import com.easydoers.employeeservice.dto.EmployeeSalesRequest;
import com.easydoers.employeeservice.dto.SaleRequest;
import com.easydoers.employeeservice.service.SaleService;

@RestController
@RequestMapping("v1/sale")
public class SaleController {
	
	@Autowired
	private SaleService saleService;
	
	@PostMapping("/saveSaleDetails")
    public ResponseEntity<String> saveSaleDetails(@RequestBody SaleRequest saleRequest){
    	String NTId = saleRequest.getEmployee().getEmployeeNtid();
    	String delaerStoreId = saleRequest.getStore().getDealerStoreId();
    	String EODReport = saleService.saveSaleDetails(NTId, delaerStoreId, saleRequest);
		return ResponseEntity.ok(EODReport);
    }
	
	@GetMapping("/getEmployeeSales")
    public ResponseEntity<EmployeeSalesDTO> getEmployeeSales(@RequestBody EmployeeSalesRequest employeeSaleRequest){
    	EmployeeSalesDTO employeeSales = saleService.getEmployeeSales(employeeSaleRequest.getEmployeeNtid());
		return ResponseEntity.ok(employeeSales);
    	
    }

}
