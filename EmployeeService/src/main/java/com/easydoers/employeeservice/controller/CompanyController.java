package com.easydoers.employeeservice.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.easydoers.employeeservice.dto.CashCollectionResponse;
import com.easydoers.employeeservice.dto.EmployeeDetailsResponse;
import com.easydoers.employeeservice.dto.StoreResponse;
import com.easydoers.employeeservice.entity.Compensation;
import com.easydoers.employeeservice.entity.Employee;
import com.easydoers.employeeservice.entity.Manager;
import com.easydoers.employeeservice.entity.Store;
import com.easydoers.employeeservice.service.CompanyService;
import com.easydoers.employeeservice.service.CompensationService;
import com.easydoers.employeeservice.service.EmployeeService;
import com.easydoers.employeeservice.service.ManagerService;
import com.easydoers.employeeservice.service.SaleService;
import com.easydoers.employeeservice.service.StoreService;

@RestController
@RequestMapping("v1/company")
public class CompanyController {

	@Autowired
	private ManagerService managerService;
	@Autowired
	private StoreService storeService;
	@Autowired
	private CompensationService compensationService;
	@Autowired
	private SaleService saleService;
	@Autowired
	private CompanyService companyService;
	@Autowired
	private EmployeeService employeeService;

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
	
	@PostMapping("/employeeRegistration")
	public ResponseEntity<String> saveEmployee(@RequestBody Employee employee) {
		Employee savedEmployee = employeeService.saveEmployee(employee);
		return ResponseEntity.ok("Employee '" + savedEmployee.getEmployeeNtid() + "' saved successfully!");
	}

	@PostMapping("/recordCompensation")
	public ResponseEntity<String> recordCompensation(@RequestBody Compensation compensation) {

		String message = compensationService.saveCompensation(compensation);
		return new ResponseEntity<String>(message, HttpStatus.OK);

	}

	@PostMapping("/assignManagerToStores")
	public ResponseEntity<String> assignManagerToStores(@RequestParam String dealerStoreId,
			@RequestParam String managerName) {
		String message = storeService.assignManagerToStores(dealerStoreId, managerName);
		return new ResponseEntity<String>(message, HttpStatus.OK);

	}

	@GetMapping("/cashCollection")
	public ResponseEntity<List<CashCollectionResponse>> cashCollectedInStores(@RequestParam String companyName,
			@RequestParam String startDate,@RequestParam String endDate) {
		LocalDate start = LocalDate.parse(startDate);
		LocalDate end = LocalDate.parse(endDate);
		List<CashCollectionResponse> response = saleService.getTotalCashAndCard(companyName, start, end);
		return new ResponseEntity<List<CashCollectionResponse>>(response, HttpStatus.OK);

	}

	@GetMapping("/viewAllStoresUnderTheCompany")
	public ResponseEntity<StoreResponse> fetchAllStores(@RequestParam String companyName) {
		StoreResponse stores = companyService.fetchStores(companyName);
		return new ResponseEntity<StoreResponse>(stores, HttpStatus.OK);

	}

	@PostMapping("/assignManagerToEmployee")
	public ResponseEntity<String> assignMangerToEmployee(@RequestParam String employeeNtid,
			@RequestParam String managerName) {
		
		String message = employeeService.assignManagerToEmployee(employeeNtid, managerName);
		return new ResponseEntity<String>(message, HttpStatus.OK);

	}
	
	@GetMapping("/viewAllEmployeesUnderTheCompany")
	public ResponseEntity<EmployeeDetailsResponse> fetchAllEmployees(@RequestParam String companyName) {
		EmployeeDetailsResponse employees = companyService.fetchEmployees(companyName);
		return new ResponseEntity<EmployeeDetailsResponse>(employees, HttpStatus.OK);

	}
}
