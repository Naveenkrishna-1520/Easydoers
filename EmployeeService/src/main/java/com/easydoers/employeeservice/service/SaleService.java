package com.easydoers.employeeservice.service;

import java.time.LocalDate;
import java.util.List;

import com.easydoers.employeeservice.dto.EmployeeSalesDTO;
import com.easydoers.employeeservice.dto.SaleRequest;
import com.easydoers.employeeservice.entity.Sale;

public interface SaleService {
	
	String saveSaleDetails(String employeeNTId, String dealerStoreId,SaleRequest saleRequest);

	EmployeeSalesDTO getEmployeeSales(String employeeNtid);

	Sale checkSaleSubmittedByEmployee(Long employeeId, LocalDate now);

	List<Sale> getEmployeeSales(Long employeeId, LocalDate start,LocalDate end);

}
