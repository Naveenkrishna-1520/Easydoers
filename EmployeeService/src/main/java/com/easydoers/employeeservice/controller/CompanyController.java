package com.easydoers.employeeservice.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.easydoers.employeeservice.dto.CashCollectionResponse;
import com.easydoers.employeeservice.dto.EmployeeDetailsDTO;
import com.easydoers.employeeservice.dto.EmployeeDetailsResponse;
import com.easydoers.employeeservice.dto.EmployeeTargetResponse;
import com.easydoers.employeeservice.dto.ManagerDetailsDTO;
import com.easydoers.employeeservice.dto.ReorderSummaryResponse;
import com.easydoers.employeeservice.dto.StoreResponse;
import com.easydoers.employeeservice.dto.StoreTargetResponse;
import com.easydoers.employeeservice.entity.Compensation;
import com.easydoers.employeeservice.entity.Employee;
import com.easydoers.employeeservice.entity.EmployeeTarget;
import com.easydoers.employeeservice.entity.Manager;
import com.easydoers.employeeservice.entity.Store;
import com.easydoers.employeeservice.entity.StoreTarget;
import com.easydoers.employeeservice.service.CompanyService;
import com.easydoers.employeeservice.service.CompensationService;
import com.easydoers.employeeservice.service.EmployeeService;
import com.easydoers.employeeservice.service.EmployeeTargetService;
import com.easydoers.employeeservice.service.InventoryService;
import com.easydoers.employeeservice.service.ManagerService;
import com.easydoers.employeeservice.service.SaleService;
import com.easydoers.employeeservice.service.StoreService;
import com.easydoers.employeeservice.service.StoreTargetService;

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
	@Autowired
	private StoreTargetService storeTargetService;
	@Autowired
	private EmployeeTargetService employeeTargetService;
	@Autowired
	private InventoryService inventoryService;

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
			@RequestParam String startDate, @RequestParam String endDate) {
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

	@PutMapping("/updateEmployee")
	public ResponseEntity<EmployeeDetailsDTO> updateEmployee(@RequestBody Employee employee) {
		EmployeeDetailsDTO updatedEmployee = employeeService.updateEmployee(employee);
		return new ResponseEntity<EmployeeDetailsDTO>(updatedEmployee, HttpStatus.OK);
	}

	@PutMapping("/updateManager")
	public ResponseEntity<ManagerDetailsDTO> updateManager(@RequestBody Manager manager) {
		ManagerDetailsDTO updatedManager = managerService.updateManager(manager);
		return new ResponseEntity<ManagerDetailsDTO>(updatedManager, HttpStatus.OK);
	}

	@DeleteMapping("/deleteEmployee")
	public ResponseEntity<String> deleteEmployee(@RequestParam String employeeNtid) {
		String message = employeeService.deleteEmployee(employeeNtid);
		return new ResponseEntity<String>(message, HttpStatus.OK);
	}

	@DeleteMapping("/deleteManager")
	public ResponseEntity<String> deleteManager(@RequestParam String managerEmail) {
		String message = managerService.deleteManager(managerEmail);
		return new ResponseEntity<String>(message, HttpStatus.OK);
	}

	@PostMapping("/storeTarget")
	public ResponseEntity<String> setStoreTargets(@RequestBody StoreTarget storeTarget) {
		String message = storeTargetService.setStoreTarget(storeTarget);
		return new ResponseEntity<String>(message, HttpStatus.OK);
	}

	@PostMapping("/employeeTarget")
	public ResponseEntity<String> setEmployeeTarget(@RequestBody EmployeeTarget employeeTarget) {
		String message = employeeTargetService.setEmployeeTarget(employeeTarget);
		return new ResponseEntity<String>(message, HttpStatus.OK);
	}

	@GetMapping("/viewStoresTargets")
	public ResponseEntity<List<StoreTargetResponse>> viewAllStoreTargets(@RequestParam String companyName,
			@RequestParam String targetMonth) {
		List<StoreTargetResponse> stores = storeTargetService.getAllStoreTargets(companyName, targetMonth);
		return new ResponseEntity<List<StoreTargetResponse>>(stores, HttpStatus.OK);
	}
	
	@GetMapping("/viewEmployeesTargets")
	public ResponseEntity<List<EmployeeTargetResponse>> viewAllEmployeeTargets(@RequestParam String companyName,
			@RequestParam String targetMonth){
		List<EmployeeTargetResponse> employees = employeeTargetService.getAllEmployeeTargets(companyName, targetMonth);
		return new ResponseEntity<List<EmployeeTargetResponse>>(employees, HttpStatus.OK);
	}
	
	@GetMapping("/reorderSummary")
	public ResponseEntity<List<ReorderSummaryResponse>> viewReorderSummary(@RequestParam String companyName){
		List<ReorderSummaryResponse> response = inventoryService.fetchStoresReorderSummaryForCompany(companyName);
		return new ResponseEntity<List<ReorderSummaryResponse>>(response, HttpStatus.OK);	
	}
	
}
