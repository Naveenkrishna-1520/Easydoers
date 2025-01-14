package com.easydoers.employeeservice.service;

import com.easydoers.employeeservice.dto.EmployeeSalesDTO;
import com.easydoers.employeeservice.dto.SaleRequest;

public interface SaleService {
	
	String saveSaleDetails(String employeeNTId, String dealerStoreId,SaleRequest saleRequest);

	EmployeeSalesDTO getEmployeeSales(String employeeNtid);

}
