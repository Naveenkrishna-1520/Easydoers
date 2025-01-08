package com.easydoers.employeeservice.controller;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.easydoers.employeeservice.dto.EmployeeSalesDTO;
import com.easydoers.employeeservice.dto.SaleRequest;
import com.easydoers.employeeservice.entity.Employee;
import com.easydoers.employeeservice.service.EmployeeServiceInterface;

@RestController
@RequestMapping("v1/employee")
public class EmployeeController {

    @Autowired
    private EmployeeServiceInterface employeeService;
    
    
    

    @PostMapping("/saveEmployee")
    public ResponseEntity<String> saveEmployee(@RequestBody Employee employee) {
        Employee savedEmployee = employeeService.saveEmployee(employee);
        return ResponseEntity.ok("Employee '" + savedEmployee.getEmployeeNtid()+ "' saved successfully!");
    }
    
    @PostMapping("/clockInRequset/{employeeNtid}/{delaerStoreId}") 
    public ResponseEntity<String> saveClokInTimeForEmployee(@PathVariable String employeeNtid, @PathVariable String delaerStoreId){
    	String saveClockInTimeForEmployee = employeeService.saveClockInTimeForEmployee(employeeNtid, delaerStoreId);
		return ResponseEntity.ok(saveClockInTimeForEmployee);
    	
    }
    
    @PostMapping("/saveSaleDetails")
    public ResponseEntity<String> saveSaleDetails(@RequestBody SaleRequest saleRequest){
    	String NTId = saleRequest.getEmployee().getEmployeeNtid();
    	String delaerStoreId = saleRequest.getStore().getDealerStoreId();
    	String EODReport = employeeService.saveSaleDetails(NTId, delaerStoreId, saleRequest);
		return ResponseEntity.ok(EODReport);
    }
    
    @GetMapping("/getEmployeeSales/{employeeNtid}")
    public ResponseEntity<EmployeeSalesDTO> getEmployeeSales(@PathVariable String employeeNtid){
    	EmployeeSalesDTO employeeSales = employeeService.getEmployeeSales(employeeNtid);
		return ResponseEntity.ok(employeeSales);
    	
    }
}
