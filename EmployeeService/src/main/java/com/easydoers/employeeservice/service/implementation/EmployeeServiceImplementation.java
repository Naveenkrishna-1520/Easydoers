package com.easydoers.employeeservice.service.implementation;

import java.security.SecureRandom;
import java.text.DecimalFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.easydoers.employeeservice.dto.EmployeeSalesDTO;
import com.easydoers.employeeservice.dto.LogInRequest;
import com.easydoers.employeeservice.dto.SaleDTO;
import com.easydoers.employeeservice.dto.SaleRequest;
import com.easydoers.employeeservice.entity.Address;
import com.easydoers.employeeservice.entity.Company;
import com.easydoers.employeeservice.entity.Employee;
import com.easydoers.employeeservice.entity.Sale;
import com.easydoers.employeeservice.entity.Store;
import com.easydoers.employeeservice.entity.Users;
import com.easydoers.employeeservice.entity.Work;
import com.easydoers.employeeservice.exception.DuplicateUserException;
import com.easydoers.employeeservice.repository.AddressRepository;
import com.easydoers.employeeservice.repository.CompanyRepository;
import com.easydoers.employeeservice.repository.EmployeeRepository;
import com.easydoers.employeeservice.repository.SaleRepository;
import com.easydoers.employeeservice.repository.StoreRepository;
import com.easydoers.employeeservice.repository.UserRepository;
import com.easydoers.employeeservice.repository.WorkRepository;
import com.easydoers.employeeservice.service.EmployeeService;

@Service
public class EmployeeServiceImplementation implements EmployeeService {

	@Autowired
	private CompanyRepository companyRepository;
	@Autowired
	private EmployeeRepository employeeRepository;
	@Autowired
	private WorkRepository workRepository;
	@Autowired
	private AddressRepository addressRepository;
	@Autowired
	private SaleRepository saleRepository;
	@Autowired
	private StoreRepository storeRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired(required = true)
	private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(12);
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private JWTTokenService tokenService;

	@Override
	public String saveSaleDetails(String employeeNTId, String dealerStoreId, SaleRequest saleRequest) {

		return saveEndOfTheDaySaleReportEnteredByEmployee(saleRequest, employeeNTId, dealerStoreId);
	}

	@Override
	public Employee saveEmployee(Employee employee) {
		if (employeeRepository.findByEmployeeNtid(employee.getEmployeeNtid()) != null) {
			throw new DuplicateUserException("Employee already exists with : " + employee.getEmployeeNtid());
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

	private String saveEndOfTheDaySaleReportEnteredByEmployee(SaleRequest saleRequest, String employeeNTId,
			String dealerStoreId) {
		Employee employee = employeeRepository.findByEmployeeNtid(employeeNTId);
		Store store = storeRepository.findByDealerStoreId(dealerStoreId);
		Sale saleCheck = saleRepository.findByEmployeeIdAndDate(employee.getEmployeeId(), LocalDate.now());
		if (saleCheck == null) {
			Sale saveSaleDetails = new Sale();
			saveSaleDetails.setEmployee(employee);
			saveSaleDetails.setStore(store);
			saveSaleDetails.setSystemAccessories(saleRequest.getSystemAccessories());
			saveSaleDetails.setAccessories(calculateAccessoriesForEmployeee(saleRequest.getSystemCard(),
					saleRequest.getSystemCash(), saleRequest.getActualCard(), saleRequest.getActualCash()));
			saveSaleDetails.setBoxesSold(saleRequest.getBoxesSold());
			saveSaleDetails.setTabletsSold(saveSaleDetails.getTabletsSold());
			saveSaleDetails.setHsiSold(saleRequest.getHsiSold());
			saveSaleDetails.setWatchesSold(saleRequest.getWatchesSold());
			saveSaleDetails.setSystemCash(saleRequest.getSystemCash());
			saveSaleDetails.setSystemCard(saleRequest.getSystemCard());
			saveSaleDetails.setActualCash(saleRequest.getActualCash());
			saveSaleDetails.setActualCard(saleRequest.getActualCard());
			saveSaleDetails.setCashExpense(saleRequest.getCashExpense());
			saveSaleDetails.setExpenseReason(saleRequest.getExpenseReason());
			saveSaleDetails.setLocalDate(LocalDate.now());
			saleRepository.save(saveSaleDetails);
			Work work = workRepository.findByEmployeeIdAndDate(employee.getEmployeeId(), LocalDate.now());
			work.setClockOutTime(LocalTime.now());
			work.setNumberOfHoursWorkedByEmployee(
					calculateNumberOfWorkedByEmployee(work.getClockOutTime(), work.getClockInTime()));
			workRepository.save(work);
			return employee.getEmployeeNtid() + " : Saved End Of The Day Report Successfully ";
		}

		return employee.getEmployeeName() + " : " + employee.getEmployeeNtid()
				+ " Already Saved End Of The Sale Report " + saleRepository.findBySaleId(saleCheck.getSaleId());
	}

	private double calculateAccessoriesForEmployeee(double systemCard, double systemCash, double actualCard,
			double actualCash) {
		double totalAccessoriesByEmployeeInCashAndCard = (actualCard - systemCard) + (actualCash - systemCash);
		return totalAccessoriesByEmployeeInCashAndCard;
	}

	private double calculateNumberOfWorkedByEmployee(LocalTime clockOutTime, LocalTime clockInTime) {
		Duration numberOfWorkedByEmployee = Duration.between(clockInTime, clockOutTime);
		double hoursWorked = numberOfWorkedByEmployee.toMinutes() / 60.0;
		DecimalFormat format = new DecimalFormat("#.##");
		double roundedValueForHoursWorked = Double.parseDouble(format.format(hoursWorked));
		return roundedValueForHoursWorked;
	}

	@Override
	public EmployeeSalesDTO getEmployeeSales(String employeeNtid) {
		System.out.println(LocalDateTime.now());
		Employee employee = employeeRepository.findByEmployeeNtid(employeeNtid);
		List<SaleDTO> salesByEmployee = saleRepository.findSalesByEmployeeId(employee.getEmployeeId());
		return new EmployeeSalesDTO(employee.getEmployeeNtid(), employee.getEmployeeName(), salesByEmployee);
	}

	@Override
	public String saveClockInTimeForEmployee(String employeeNtid, String dealerStoreId) {
		Employee employee = employeeRepository.findByEmployeeNtid(employeeNtid);
		Store store = storeRepository.findByDealerStoreId(dealerStoreId);
		Work work = workRepository.findByEmployeeIdAndDate(employee.getEmployeeId(), LocalDate.now());
		if (work == null) {
			Work workRequset = new Work();
			workRequset.setEmployee(employee);
			workRequset.setStore(store);
			workRequset.setClockInTime(LocalTime.now());
			workRequset.setDate(LocalDate.now());
			workRepository.save(workRequset);
			return "Employee successfully clocked in at : " + workRequset.getClockInTime();
		}
		return "Employee already clocked in at : " + work.getClockInTime();
	}

	public String getSerialNumber() {
		String serialNumber = "";
		try {
			Process process = Runtime.getRuntime().exec("ioreg -l | grep IOPlatformSerialNumber");
			BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
			String line;
			while ((line = reader.readLine()) != null) {
				if (line.contains("IOPlatformSerialNumber")) {
					serialNumber = line.split("\"")[3]; // Extract the serial number
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "Error retrieving serial number";
		}
		return serialNumber;
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
		Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(logInRequest.getUserName(),logInRequest.getPassword()));
		
	 if(authentication.isAuthenticated()) {
			return tokenService.generateToken(logInRequest.getUserName());
		}
	return "failure";
	}

}
