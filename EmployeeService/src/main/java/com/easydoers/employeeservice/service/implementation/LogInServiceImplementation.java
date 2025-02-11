package com.easydoers.employeeservice.service.implementation;

import java.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseCookie;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import static com.easydoers.employeeservice.constants.RoleConstants.*;
import com.easydoers.employeeservice.dto.EmployeeDTO;
import com.easydoers.employeeservice.dto.LogInRequest;
import com.easydoers.employeeservice.dto.LogInResponse;
import com.easydoers.employeeservice.dto.RefreshTokenResponse;
import com.easydoers.employeeservice.dto.StoreDTO;
import com.easydoers.employeeservice.entity.Company;
import com.easydoers.employeeservice.entity.Employee;
import com.easydoers.employeeservice.entity.Manager;
import com.easydoers.employeeservice.entity.Sale;
import com.easydoers.employeeservice.entity.Store;
import com.easydoers.employeeservice.entity.Users;
import com.easydoers.employeeservice.entity.Work;
import com.easydoers.employeeservice.service.CompanyService;
import com.easydoers.employeeservice.service.CookieSetupService;
import com.easydoers.employeeservice.service.EmployeeService;
import com.easydoers.employeeservice.service.LogInService;
import com.easydoers.employeeservice.service.ManagerService;
import com.easydoers.employeeservice.service.SaleService;
import com.easydoers.employeeservice.service.StoreService;
import com.easydoers.employeeservice.service.UserService;
import com.easydoers.employeeservice.service.WorkService;

@Service
public class LogInServiceImplementation implements LogInService {

	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private StoreService storeService;
	@Autowired
	private JWTTokenService tokenService;
	@Autowired
	private CookieSetupService cookieSetupService;
	@Autowired
	private WorkService workService;
	@Autowired
	private SaleService saleService;
	@Autowired
	private JWTTokenService jwtTokenService;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private UserService userService;
	@Autowired
	private ManagerService managerService;
	@Autowired
	private CompanyService companyService;

	@Override
	public LogInResponse loginUser(LogInRequest logInRequest) {
		LogInResponse response = new LogInResponse();

		if (logInRequest.getUserName().contains("@")) {
			response = handleUserLogin(logInRequest);
		} else {
			response = handleEmployeeLogin(logInRequest);
		}

		return response;
	}

	private LogInResponse handleUserLogin(LogInRequest logInRequest) {
		LogInResponse response = new LogInResponse();
		Users user = userService.findByUserName(logInRequest.getUserName());

		if (user != null && passwordEncoder.matches(logInRequest.getPassword(), user.getPassword())) {
			response = generateToken(logInRequest, user.getRole());
			response.setLoginEmail(user.getUserName());
			if (user.getRole() != ADMIN) {
				response.setLoginPerson(setName(user.getUserName()));
			}
		} else {
			response.setMessage("User not found " + logInRequest.getUserName());
		}

		return response;
	}

	private String setName(String userName) {
		Manager manager = managerService.isManagerAvailable(userName);
		Company company = companyService.isCompanyAvailable(userName);
		if (manager != null) {
			return manager.getManagerName();
		}
		return company.getCompanyName();
	}

	private LogInResponse handleEmployeeLogin(LogInRequest logInRequest) {
		LogInResponse response = new LogInResponse();
		Employee employee = employeeService.checkEmployee(logInRequest.getPassword());
		Store store = storeService.checkStore(logInRequest.getUserName());

		if (employee != null && store != null) {
			response = setupEmployeeResponse(employee, store, logInRequest);
		}

		return response;
	}

	private LogInResponse setupEmployeeResponse(Employee employee, Store store, LogInRequest logInRequest) {
		LogInResponse response = new LogInResponse();

		// Set employee and store information
		EmployeeDTO employeeDTO = new EmployeeDTO(employee.getEmployeeNtid(), employee.getEmployeeName());
		StoreDTO storeDTO = new StoreDTO(store.getDealerStoreId(), store.getStoreName());
		response.setEmployee(employeeDTO);
		response.setStore(storeDTO);

		// Generate token
		response = generateToken(logInRequest, EMPLOYEE);

		// Set clock-in status
		Work clockinStatus = workService.checkClockinStatus(employee.getEmployeeId(), LocalDate.now());
		if (clockinStatus != null) {
			response.setIsClockin("true");
			response.setClockinTime(clockinStatus.getClockInTime());
			response.setClockinLocation(clockinStatus.getStore().getStoreName());
		} else {
			response.setIsClockin("false");
		}

		// Set sale submission status
		Sale sale = saleService.checkSaleSubmittedByEmployee(employee.getEmployeeId(), LocalDate.now());
		response.setIsSaleSubmit(sale != null ? "true" : "false");

		return response;
	}

	private LogInResponse generateToken(LogInRequest logInRequest, String role) {
		LogInResponse response = new LogInResponse();
		String jwtToken = tokenService.generateToken(logInRequest.getUserName(), role);
		String refreshJwtToken = tokenService.generateRefreshToken(logInRequest.getUserName(), role);
		ResponseCookie cookie = cookieSetupService.setupJwtCookie(jwtToken);
		ResponseCookie refreshCookie = cookieSetupService.setupRefreshJwtCookie(refreshJwtToken);
		response.setToken(cookie.toString());
		response.setRefreshToken(refreshCookie.toString());
		return response;

	}

	@Override
	public RefreshTokenResponse checkTokenRefresh(String refreshToken) {

		RefreshTokenResponse response = new RefreshTokenResponse();
		if (jwtTokenService.validateRefreshToken(refreshToken)) {
			String userName = jwtTokenService.extractUserNameFromRefreshToken(refreshToken);
			String role = jwtTokenService.getRoleFromRefershToken(refreshToken);
			String newAccessToken = jwtTokenService.generateToken(userName, role);
			ResponseCookie cookie = cookieSetupService.setupJwtCookie(newAccessToken);
			response.setAccesstoken(cookie.toString());
			response.setTokenRefreshed(true);
			return response;
		}
		return response;
	}
}
