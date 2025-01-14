package com.easydoers.employeeservice.service.implementation;

import java.security.SecureRandom;
import java.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.easydoers.employeeservice.dto.ClockinResponse;
import com.easydoers.employeeservice.dto.LogInRequest;
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
import com.easydoers.employeeservice.service.EmployeeService;
import com.easydoers.employeeservice.service.StoreService;
import com.easydoers.employeeservice.service.WorkService;

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
	private AuthenticationManager authenticationManager;
	@Autowired
	private JWTTokenService tokenService;

	@Override
	public Employee saveEmployee(Employee employee) {
		if (checkEmployee(employee.getEmployeeNtid()) != null) {
			throw new DuplicateUserFoundException("Employee already exists with : " + employee.getEmployeeNtid());
		}
		Address employeeAddress = employee.getAddress();
		addressRepository.save(employeeAddress);
		Users user = new Users();
		user.setUserName(employee.getEmail());
		user.setPassword(passwordEncoder.encode(createPassword()));
		userRepository.save(user);
		Company employeeCompany = companyRepository.findByCompanyName(employee.getCompany().getCompanyName());
		employee.setCompany(employeeCompany);
		return employeeRepository.save(employee);
	}

	@Override
	public ClockinResponse saveClockInTimeForEmployee(String employeeNtid, String dealerStoreId) {
			Employee employee = checkEmployee(employeeNtid);
			Store store = storeService.checkStore(dealerStoreId);
			 ClockinResponse response = workService.findByEmployeeInWork(employee, LocalDate.now(), store);
			return response;

	}


	private CharSequence createPassword() {
		String upperCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String lowerCase = "abcdefghijklmnopqrstuvwxyz";
		String digits = "0123456789";
		String symbols = "!@#$%^&*()-_+=<>?";
		String allChars = upperCase + lowerCase + digits + symbols;
		SecureRandom random = new SecureRandom();
		StringBuilder password = new StringBuilder();
		password.append(upperCase.charAt(random.nextInt(upperCase.length())));
		password.append(lowerCase.charAt(random.nextInt(lowerCase.length())));
		password.append(digits.charAt(random.nextInt(digits.length())));
		password.append(symbols.charAt(random.nextInt(symbols.length())));

		for (int i = 4; i < 10; i++) {
			password.append(allChars.charAt(random.nextInt(allChars.length())));
		}

		return shuffleString(password.toString(), random);
	}

	private static String shuffleString(String input, SecureRandom random) {
		char[] chars = input.toCharArray();
		for (int i = chars.length - 1; i > 0; i--) {
			int j = random.nextInt(i + 1);
			char temp = chars[i];
			chars[i] = chars[j];
			chars[j] = temp;
		}
		return new String(chars);
	}

	@Override
	public String validateUser(LogInRequest logInRequest) {

		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(logInRequest.getUserName(), logInRequest.getPassword()));
		if (authentication.isAuthenticated()) {
			return tokenService.generateToken(logInRequest.getUserName());
		}
		return "failure";
	}

	public Employee checkEmployee(String employeeNtid) {

		Employee employee = employeeRepository.findByEmployeeNtid(employeeNtid);
		if (employee == null) {
			throw new EmployeeNotFoundException("employee with " + employeeNtid + " not found");
		}
		return employee;
	}
}
