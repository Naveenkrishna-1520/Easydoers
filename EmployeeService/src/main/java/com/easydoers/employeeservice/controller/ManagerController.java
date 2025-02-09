package com.easydoers.employeeservice.controller;

import java.time.LocalDate;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.easydoers.employeeservice.dto.PayslipRequest;
import com.easydoers.employeeservice.dto.PayslipResponse;
import com.easydoers.employeeservice.entity.Employee;
import com.easydoers.employeeservice.entity.Expense;
import com.easydoers.employeeservice.service.EmployeeService;
import com.easydoers.employeeservice.service.ExpenseService;
import com.easydoers.employeeservice.service.PayslipService;

@RestController
@RequestMapping("v1/manager")
public class ManagerController {


	@Autowired
	private PayslipService payslipService;
	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private ExpenseService expenseService;

	@PostMapping("/employeeRegistration")
	public ResponseEntity<String> saveEmployee(@RequestBody Employee employee) {
		Employee savedEmployee = employeeService.saveEmployee(employee);
		return ResponseEntity.ok("Employee '" + savedEmployee.getEmployeeNtid() + "' saved successfully!");
	}
	
	@PostMapping("/recordStoreExpenses")
	public ResponseEntity<Expense> recordStoreExpenses(@RequestBody Expense expense){
		
	Expense expenses = expenseService.saveExpense(expense);
		return new ResponseEntity<Expense>(expenses, HttpStatus.OK);
		
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

}
