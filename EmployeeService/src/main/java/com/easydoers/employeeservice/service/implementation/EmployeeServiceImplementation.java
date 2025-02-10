package com.easydoers.employeeservice.service.implementation;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.easydoers.employeeservice.dto.AuthorizedStoreAccessResponse;
import com.easydoers.employeeservice.dto.ClockinResponse;
import com.easydoers.employeeservice.dto.StoreDTO;
import com.easydoers.employeeservice.entity.Address;
import com.easydoers.employeeservice.entity.Company;
import com.easydoers.employeeservice.entity.Employee;
import com.easydoers.employeeservice.entity.Manager;
import com.easydoers.employeeservice.entity.Store;
import com.easydoers.employeeservice.exception.DuplicateUserFoundException;
import com.easydoers.employeeservice.exception.EmployeeNotFoundException;
import com.easydoers.employeeservice.repository.AddressRepository;
import com.easydoers.employeeservice.repository.EmployeeRepository;
import com.easydoers.employeeservice.service.CompanyService;
import com.easydoers.employeeservice.service.EmployeeService;
import com.easydoers.employeeservice.service.ManagerService;
import com.easydoers.employeeservice.service.StoreService;
import com.easydoers.employeeservice.service.WorkService;

@Service
public class EmployeeServiceImplementation implements EmployeeService {

	
	@Autowired
	private EmployeeRepository employeeRepository;
	@Autowired
	private WorkService workService;
	@Autowired
	private AddressRepository addressRepository;
	@Autowired
	private StoreService storeService;
	@Autowired
	private CompanyService companyService;
	@Autowired
	private ManagerService managerService;
	
	@Override
	public Employee saveEmployee(Employee employee) {
		if (checkEmployeeWhileRegistration(employee.getEmployeeNtid()) != null) {
			throw new DuplicateUserFoundException("Employee already exists with : " + employee.getEmployeeNtid());
		}
		Address employeeAddress = employee.getAddress();
		employeeAddress = addressRepository.save(employeeAddress);		
		Manager employeeManager = managerService.checkManager(employee.getManager().getManagerName());
		Company employeeCompany = companyService.checkCompany(employeeManager.getCompany().getCompanyName());
		employee.setCompany(employeeCompany);
		employee.setAddress(employeeAddress);
		employee.setManager(employeeManager);
		return employeeRepository.save(employee);
	}

	@Override
	public ClockinResponse saveClockInTimeForEmployee(String employeeNtid, String dealerStoreId) {
		Employee employee = checkEmployee(employeeNtid);
		Store store = storeService.checkStore(dealerStoreId);
		ClockinResponse response = workService.findByEmployeeInWork(employee, LocalDate.now(), store);
		return response;

	}

	public Employee checkEmployee(String employeeNtid) {

		Employee employee = employeeRepository.findByEmployeeNtid(employeeNtid);

		if (employee == null) {
			throw new EmployeeNotFoundException("employee with " + employeeNtid + " not found");
		}

		return employee;
	}

	public Employee checkEmployeeWhileRegistration(String employeeNtid) {

		Employee employee = employeeRepository.findByEmployeeNtid(employeeNtid);

		return employee;
	}
	@Override
	public AuthorizedStoreAccessResponse getAuthorizedStores(String employeeNtid) {
		List<StoreDTO> storeList = new ArrayList<>();
		Employee employee = checkEmployee(employeeNtid);
		Company company = companyService.getCompany(employee.getCompany().getCompanyId());
		List<Store> stores = storeService.getStoresUnderCompany(company);
		for (Store store : stores) {
			StoreDTO storeDTO = new StoreDTO();
			storeDTO.setDealerStoreId(store.getDealerStoreId());
			storeDTO.setStoreName(store.getStoreName());
			storeList.add(storeDTO);

		}
		return new AuthorizedStoreAccessResponse(storeList);
	}
}
