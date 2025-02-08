package com.easydoers.employeeservice.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.easydoers.employeeservice.entity.Address;
import com.easydoers.employeeservice.entity.Company;
import com.easydoers.employeeservice.entity.Manager;
import com.easydoers.employeeservice.exception.DuplicateUserFoundException;
import com.easydoers.employeeservice.exception.EmployeeNotFoundException;
import com.easydoers.employeeservice.repository.AddressRepository;
import com.easydoers.employeeservice.repository.CompanyRepository;
import com.easydoers.employeeservice.repository.ManagerRepository;
import com.easydoers.employeeservice.service.ManagerService;

@Service
public class ManagerServiceImplementation implements ManagerService{
	
	@Autowired
	private ManagerRepository managerRepository;
	@Autowired
	private AddressRepository addressRepository;
	@Autowired
	private CompanyRepository companyRepository;

	@Override
	public String createManager(Manager manager) {
		if (checkManager(manager.getManagerNtid()) != null) {
			throw new DuplicateUserFoundException("Manager already exists with : " + manager.getManagerNtid());
		}
		Company managerCompany = companyRepository.findByCompanyName(manager.getCompany().getCompanyName());
		Address managerAddress = manager.getAddress();
		managerAddress = addressRepository.save(managerAddress);
		manager.setAddress(managerAddress);
		manager.setCompany(managerCompany);
		managerRepository.save(manager);
		return "Manager created successfully";
	}

	public Manager checkManager(String managerNtid) {
		Manager manager = managerRepository.findByManagerNtid(managerNtid);
		if (manager == null) {
			throw new EmployeeNotFoundException("manager with " + managerNtid + " not found");
		}
		return manager;
	}

}
