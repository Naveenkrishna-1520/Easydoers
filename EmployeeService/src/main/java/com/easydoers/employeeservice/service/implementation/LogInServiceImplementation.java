package com.easydoers.employeeservice.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.easydoers.employeeservice.dto.EmployeeDTO;
import com.easydoers.employeeservice.dto.LogInRequest;
import com.easydoers.employeeservice.dto.LogInResponse;
import com.easydoers.employeeservice.dto.StoreDTO;
import com.easydoers.employeeservice.entity.Employee;
import com.easydoers.employeeservice.entity.Store;
import com.easydoers.employeeservice.service.EmployeeService;
import com.easydoers.employeeservice.service.LogInService;
import com.easydoers.employeeservice.service.StoreService;

@Service
public class LogInServiceImplementation implements LogInService{
	
	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private StoreService storeService;
	@Autowired
	private JWTTokenService tokenService;

	@Override
	public LogInResponse loginUser(LogInRequest logInRequest) {

		LogInResponse response = new LogInResponse();
		Employee employee = employeeService.checkEmployee(logInRequest.getPassword());
		Store store = storeService.checkStore(logInRequest.getUserName());
		EmployeeDTO employeeDTO = new EmployeeDTO();
		StoreDTO storeDTO = new StoreDTO();
		employeeDTO.setEmployeeNtid(employee.getEmployeeNtid());
		employeeDTO.setEmployeeName(employee.getEmployeeName());
		storeDTO.setDealerStoreId(store.getDealerStoreId());
		storeDTO.setStoreName(store.getStoreName());
		response.setEmployee(employeeDTO);
		response.setStore(storeDTO);
		response.setBearerToken(tokenService.generateToken(logInRequest.getUserName()));
		return response;
	}
}
