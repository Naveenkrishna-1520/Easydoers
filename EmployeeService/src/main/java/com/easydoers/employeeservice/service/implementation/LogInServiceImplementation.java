package com.easydoers.employeeservice.service.implementation;

import java.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseCookie;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.easydoers.employeeservice.dto.EmployeeDTO;
import com.easydoers.employeeservice.dto.LogInRequest;
import com.easydoers.employeeservice.dto.LogInResponse;
import com.easydoers.employeeservice.dto.RefreshTokenResponse;
import com.easydoers.employeeservice.dto.StoreDTO;
import com.easydoers.employeeservice.entity.Employee;
import com.easydoers.employeeservice.entity.Sale;
import com.easydoers.employeeservice.entity.Store;
import com.easydoers.employeeservice.entity.Users;
import com.easydoers.employeeservice.entity.Work;
import com.easydoers.employeeservice.service.CookieSetupService;
import com.easydoers.employeeservice.service.EmployeeService;
import com.easydoers.employeeservice.service.LogInService;
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

	@Override
	public LogInResponse loginUser(LogInRequest logInRequest) {

		LogInResponse response = new LogInResponse();
		String role = null;
		Employee employee = employeeService.checkEmployee(logInRequest.getPassword());
		Store store = storeService.checkStore(logInRequest.getUserName());
		if (store != null && employee != null) {
			role = "EMPLOYEE";
			EmployeeDTO employeeDTO = new EmployeeDTO();
			StoreDTO storeDTO = new StoreDTO();
			employeeDTO.setEmployeeNtid(employee.getEmployeeNtid());
			employeeDTO.setEmployeeName(employee.getEmployeeName());
			storeDTO.setDealerStoreId(store.getDealerStoreId());
			storeDTO.setStoreName(store.getStoreName());
			response.setEmployee(employeeDTO);
			response.setStore(storeDTO);
			Work checkClockinStatus = workService.checkClockinStatus(employee.getEmployeeId(), LocalDate.now());
			if (checkClockinStatus != null) {
				response.setClockin(true);
				response.setClockinTime(checkClockinStatus.getClockInTime());
			}
			Sale sale = saleService.checkSaleSubmittedByEmployee(employee.getEmployeeId(), LocalDate.now());
			if (sale != null) {
				response.setSaleSubmit(true);

			}
		} else {
			Users user = userService.findByUserName(logInRequest.getUserName());
			if (user != null && passwordEncoder.matches(logInRequest.getPassword(), user.getPassword())) {
				role = user.getRole();
			}
		}

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
