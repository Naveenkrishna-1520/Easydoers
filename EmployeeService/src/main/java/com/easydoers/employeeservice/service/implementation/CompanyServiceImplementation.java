package com.easydoers.employeeservice.service.implementation;



import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.easydoers.employeeservice.entity.Address;
import com.easydoers.employeeservice.entity.Company;
import com.easydoers.employeeservice.entity.Users;
import com.easydoers.employeeservice.exception.DuplicateCompanyFoundException;
import com.easydoers.employeeservice.repository.AddressRepository;
import com.easydoers.employeeservice.repository.CompanyRepository;
import com.easydoers.employeeservice.repository.UserRepository;
import com.easydoers.employeeservice.service.CompanyService;
import com.easydoers.employeeservice.service.EmailService;
import com.easydoers.employeeservice.util.PasswordCreatorUtil;


@Service
public class CompanyServiceImplementation implements CompanyService{
	
	@Autowired
	private CompanyRepository companyRepository;
	@Autowired
	private AddressRepository  addressRepository;
	@Autowired
	private PasswordCreatorUtil passwordCreatorUtil;
	@Autowired(required = true)
	private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(12);
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private EmailService emailService;
	

	@Override
	public Company getCompany(int companyId) {
		Company company = companyRepository.findBycompanyId(companyId);
		return company;
	}

	@Override
	public String createCompany(Company company) {
		if (checkCompany(company.getCompanyName()) != null) {
			throw new DuplicateCompanyFoundException("Company already exists with : " + company.getCompanyName());
		}
		Address companyAddress = company.getCompanyAddress();
		companyAddress = addressRepository.save(companyAddress);
		Users user = new Users();
		user.setUserName(company.getEmail());
		CharSequence password =passwordCreatorUtil.createPassword(company.getEmail());
		user.setPassword(passwordEncoder.encode(password));
		user.setRole("OWNER");
		userRepository.save(user);
		company.setCompanyAddress(companyAddress);
		company.setUpdatedPerson(company.getUpdatedPerson());
		company.setUpdateTime(LocalDateTime.now());
		companyRepository.save(company);
		// Trigger the email after creating the company
	    emailService.sendCompanyCreationEmail(company.getEmail(), company.getCompanyName(), user.getUserName(), password.toString());
		return "Company created successfully";
	}

	private Company checkCompany(String companyName) {
		Company company = companyRepository.findByCompanyName(companyName);
		return company;
	}
	

}
