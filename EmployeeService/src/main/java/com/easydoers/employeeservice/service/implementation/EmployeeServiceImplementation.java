package com.easydoers.employeeservice.service.implementation;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import com.easydoers.employeeservice.dto.AuthorizedStoreAccessResponse;
import com.easydoers.employeeservice.dto.ClockinResponse;
import com.easydoers.employeeservice.dto.EmployeeDetailsDTO;
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
	@Lazy
	private CompanyService companyService;
	@Autowired
	private ManagerService managerService;
	
	@Override
	public Employee saveEmployee(Employee employee) {
		if (isEmployeeAvailable(employee.getEmployeeNtid()) != null) {
			throw new DuplicateUserFoundException("Employee already exists with : " + employee.getEmployeeNtid());
		}
		Address employeeAddress = employee.getAddress();
		employeeAddress = addressRepository.save(employeeAddress);		
		Company employeeCompany = companyService.checkCompany(employee.getCompany().getCompanyName());
		employee.setCompany(employeeCompany);
		employee.setAddress(employeeAddress);
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

	public Employee isEmployeeAvailable(String employeeNtid) {

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

	@Override
	public String assignManagerToEmployee(String employeeNtid, String managerName) {
		Manager manager = managerService.checkManager(managerName);
		Employee employee = checkEmployee(employeeNtid);
		employee.setManager(manager);
		employeeRepository.save(employee);
		return "Manager : "+managerName+" is successfully assigned to employee : "+employee.getEmployeeName();
	}

	@Override
	public List<Employee> getEmployeesUnderCompany(Company company) {
		
		return employeeRepository.findByCompany(company);
	}

	@Override
	public String deleteEmployee(String employeeNtid) {
		Employee employee = checkEmployee(employeeNtid);
		employeeRepository.delete(employee);
		return "Employee deleted successfully";
	}

	@Override
	public EmployeeDetailsDTO updateEmployee(Employee employee) {
		employee = employeeRepository.save(employee);
		return new EmployeeDetailsDTO(employee.getEmployeeId(), employee.getEmployeeNtid(),
				employee.getEmployeeName(), employee.getPhoneNumber(), employee.getEmail(),
				employee.getEmployeePayRatePerHour(), employee.getCommissionPercentage(),
				employee.getPerBoxCommission());
	}
}
