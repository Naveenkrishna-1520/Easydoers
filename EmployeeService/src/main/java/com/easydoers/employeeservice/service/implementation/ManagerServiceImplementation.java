package com.easydoers.employeeservice.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import static com.easydoers.employeeservice.constants.RoleConstants.*;
import com.easydoers.employeeservice.entity.Address;
import com.easydoers.employeeservice.entity.Company;
import com.easydoers.employeeservice.entity.Manager;
import com.easydoers.employeeservice.entity.Users;
import com.easydoers.employeeservice.exception.DuplicateUserFoundException;
import com.easydoers.employeeservice.exception.ManagerNotFoundException;
import com.easydoers.employeeservice.repository.AddressRepository;
import com.easydoers.employeeservice.repository.CompanyRepository;
import com.easydoers.employeeservice.repository.ManagerRepository;
import com.easydoers.employeeservice.repository.UserRepository;
import com.easydoers.employeeservice.service.EmailService;
import com.easydoers.employeeservice.service.ManagerService;
import com.easydoers.employeeservice.util.PasswordCreatorUtil;

@Service
public class ManagerServiceImplementation implements ManagerService {

	@Autowired
	private ManagerRepository managerRepository;
	@Autowired
	private AddressRepository addressRepository;
	@Autowired
	private CompanyRepository companyRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private PasswordCreatorUtil passwordCreatorUtil;
	@Autowired(required = true)
	private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(12);
	@Autowired
	private EmailService emailService;

	@Override
	public String createManager(Manager manager) {
		Users user = new Users();
		CharSequence password = null;
		if (checkManagerWhileRegistration(manager.getManagerNtid()) != null) {
			throw new DuplicateUserFoundException("Manager already exists with : " + manager.getManagerNtid());
		}
		Company managerCompany = companyRepository.findByCompanyName(manager.getCompany().getCompanyName());
		Address managerAddress = manager.getAddress();
		managerAddress = addressRepository.save(managerAddress);
		if (userRepository.findByUserName(manager.getEmail()) == null) {
			user.setUserName(manager.getEmail());
			password = passwordCreatorUtil.createPassword(manager.getEmail());
			user.setPassword(passwordEncoder.encode(password));
			user.setRole(MANAGER);
			userRepository.save(user);
		}
		manager.setAddress(managerAddress);
		manager.setCompany(managerCompany);
		managerRepository.save(manager);
		emailService.sendManagerCredentialsEmail(manager.getCompany().getCompanyName(), manager.getManagerName(),
				manager.getEmail(), password.toString());
		return "Manager created successfully";
	}

	private Manager checkManagerWhileRegistration(String managerNtid) {
		Manager manager = managerRepository.findByManagerNtid(managerNtid);
		return manager;
	}

	public Manager checkManager(String managerName) {
		Manager manager = managerRepository.findByManagerName(managerName);

		if (manager == null) {
			throw new ManagerNotFoundException("manager with " + managerName + " not found");
		}

		return manager;
	}

	@Override
	public Manager isManagerAvailable(String userName) {
		Manager manager = managerRepository.findByEmail(userName);
		return manager;
	}

}
