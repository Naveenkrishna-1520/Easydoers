package com.easydoers.employeeservice.service.implementation;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.easydoers.employeeservice.dto.AuthorizedStoreAccessResponse;
import com.easydoers.employeeservice.dto.ClockinResponse;
import com.easydoers.employeeservice.dto.StoreDTO;
import com.easydoers.employeeservice.entity.Address;
import com.easydoers.employeeservice.entity.Company;
import com.easydoers.employeeservice.entity.Employee;
import com.easydoers.employeeservice.entity.Store;
import com.easydoers.employeeservice.entity.Users;
import com.easydoers.employeeservice.exception.DuplicateUserFoundException;
import com.easydoers.employeeservice.exception.EmployeeNotFoundException;
import com.easydoers.employeeservice.repository.AddressRepository;
import com.easydoers.employeeservice.repository.CompanyRepository;
import com.easydoers.employeeservice.repository.EmployeeRepository;
import com.easydoers.employeeservice.repository.UserRepository;
import com.easydoers.employeeservice.service.CompanyService;
import com.easydoers.employeeservice.service.EmployeeService;
import com.easydoers.employeeservice.service.StoreService;
import com.easydoers.employeeservice.service.WorkService;
import com.easydoers.employeeservice.util.PasswordCreatorUtil;

@Service
public class EmployeeServiceImplementation implements EmployeeService {

	@Autowired
	private CompanyRepository companyRepository;
	@Autowired
	private EmployeeRepository employeeRepository;
	@Autowired
	private WorkService workService;
	@Autowired
	private AddressRepository addressRepository;
	@Autowired
	private StoreService storeService;
	@Autowired
	private UserRepository userRepository;
	@Autowired(required = true)
	private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(12);
	@Autowired
	private CompanyService companyService;
	@Autowired
	private PasswordCreatorUtil passwordCreatorUtil;

	@Override
	public Employee saveEmployee(Employee employee) {
		if (checkEmployee(employee.getEmployeeNtid()) != null) {
			throw new DuplicateUserFoundException("Employee already exists with : " + employee.getEmployeeNtid());
		}
		Address employeeAddress = employee.getAddress();
		employeeAddress = addressRepository.save(employeeAddress);
		Users user = new Users();
		user.setUserName(employee.getEmail());
		user.setPassword(passwordEncoder.encode(passwordCreatorUtil.createPassword(employee.getEmail())));
		user.setRole("EMPLOYEE");
		userRepository.save(user);
		Company employeeCompany = companyRepository.findByCompanyName(employee.getCompany().getCompanyName());
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
