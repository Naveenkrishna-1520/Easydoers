package com.easydoers.employeeservice.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.easydoers.employeeservice.dto.AddMinimumInventoryRequest;
import com.easydoers.employeeservice.dto.DeleteProductRequest;
import com.easydoers.employeeservice.dto.EmployeeTargetResponse;
import com.easydoers.employeeservice.dto.PayslipRequest;
import com.easydoers.employeeservice.dto.PayslipResponse;
import com.easydoers.employeeservice.dto.ReorderSummaryResponse;
import com.easydoers.employeeservice.dto.StoreTargetResponse;
import com.easydoers.employeeservice.entity.EmployeeTarget;
import com.easydoers.employeeservice.entity.Expense;
import com.easydoers.employeeservice.entity.StoreTarget;
import com.easydoers.employeeservice.service.EmployeeTargetService;
import com.easydoers.employeeservice.service.ExpenseService;
import com.easydoers.employeeservice.service.InventoryService;
import com.easydoers.employeeservice.service.PayslipService;
import com.easydoers.employeeservice.service.StoreTargetService;

@RestController
@RequestMapping("v1/manager")
public class ManagerController {

	@Autowired
	private PayslipService payslipService;
	@Autowired
	private ExpenseService expenseService;
	@Autowired
	private InventoryService inventoryService;
	@Autowired
	private StoreTargetService storeTargetService;
	@Autowired
	private EmployeeTargetService employeeTargetService;


	@PostMapping("/recordStoreExpenses")
	public ResponseEntity<Expense> recordStoreExpenses(@RequestBody Expense expense) {

		Expense expenses = expenseService.saveExpense(expense);
		return new ResponseEntity<Expense>(expenses, HttpStatus.OK);

	}

	@PostMapping("/addInventory")
	public ResponseEntity<Map<String, Object>> addMinimumInventoryToStores(
			@RequestBody AddMinimumInventoryRequest inventoryRequest) {
		Map<String, Object> response = inventoryService.addMinimumInventoryToStores(inventoryRequest);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);

	}

	@DeleteMapping("/delete")
	public ResponseEntity<Map<String, Object>> deleteProductFromStoreInventory(
			@RequestBody DeleteProductRequest deleteProductRequest) {
		Map<String, Object> response = inventoryService.deleteInventoryfromStore(deleteProductRequest);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);

	}

	@GetMapping("/payslip")
	public ResponseEntity<byte[]> calculateEmployeePay(@RequestBody PayslipRequest payslipRequest) {

		try {
			LocalDate start = LocalDate.parse(payslipRequest.getStartDate());
			LocalDate end = LocalDate.parse(payslipRequest.getEndDate());
			Map<byte[], PayslipResponse> response = payslipService
					.generatePayslipForEmployee(payslipRequest.getEmployeeNtid(), start, end);
			byte[] pdfBytes = response.keySet().iterator().next();
			PayslipResponse payslipResponse = response.values().iterator().next();
			if (pdfBytes == null || pdfBytes.length == 0) {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
						.body(("Error: " + payslipResponse.getPaySlip()).getBytes());
			}
			HttpHeaders headers = new HttpHeaders();
			headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + payslipResponse);
			headers.add(HttpHeaders.CONTENT_TYPE, "application/pdf");
			return new ResponseEntity<>(pdfBytes, headers, HttpStatus.OK);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(("Error generating payslip: " + e.getMessage()).getBytes());
		}
	}
	
	@GetMapping("/reorderSummay")
	public ResponseEntity<List<ReorderSummaryResponse>> viewReorderSummary(@RequestParam String managerName){
		List<ReorderSummaryResponse> response = inventoryService.fetchStoresReorderSummary(managerName);
		return new ResponseEntity<List<ReorderSummaryResponse>>(response, HttpStatus.OK);	
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
	public ResponseEntity<List<StoreTargetResponse>> viewAllStoreTargets(@RequestParam String managerName,
			@RequestParam String targetMonth) {
		List<StoreTargetResponse> stores = storeTargetService.getAllStoreTargetsForManager(managerName, targetMonth);
		return new ResponseEntity<List<StoreTargetResponse>>(stores, HttpStatus.OK);
	}
	
	@GetMapping("/viewEmployeesTargets")
	public ResponseEntity<List<EmployeeTargetResponse>> viewAllEmployeeTargets(@RequestParam String managerName,
			@RequestParam String targetMonth){
		List<EmployeeTargetResponse> employees = employeeTargetService.getAllEmployeeTargetsForEmployee(managerName, targetMonth);
		return new ResponseEntity<List<EmployeeTargetResponse>>(employees, HttpStatus.OK);
	}

}
