package com.easydoers.employeeservice.service.implementation;

import java.time.LocalDateTime;
import java.util.List;
import static com.easydoers.employeeservice.constants.RoleConstants.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.easydoers.employeeservice.dto.CompanyDTO;
import com.easydoers.employeeservice.dto.CompanyResponse;
import com.easydoers.employeeservice.dto.StoreDTO;
import com.easydoers.employeeservice.dto.StoreResponse;
import com.easydoers.employeeservice.entity.Address;
import com.easydoers.employeeservice.entity.Company;
import com.easydoers.employeeservice.entity.Store;
import com.easydoers.employeeservice.entity.Users;
import com.easydoers.employeeservice.exception.CompanyNotFoundException;
import com.easydoers.employeeservice.exception.DuplicateCompanyFoundException;
import com.easydoers.employeeservice.repository.AddressRepository;
import com.easydoers.employeeservice.repository.CompanyRepository;
import com.easydoers.employeeservice.repository.UserRepository;
import com.easydoers.employeeservice.service.CompanyService;
import com.easydoers.employeeservice.service.EmailService;
import com.easydoers.employeeservice.service.StoreService;
import com.easydoers.employeeservice.util.PasswordCreatorUtil;

@Service
public class CompanyServiceImplementation implements CompanyService {

	@Autowired
	private CompanyRepository companyRepository;
	@Autowired
	private AddressRepository addressRepository;
	@Autowired
	private PasswordCreatorUtil passwordCreatorUtil;
	@Autowired(required = true)
	private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(12);
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private EmailService emailService;
	@Autowired
	@Lazy
	private StoreService storeService;

	@Override
	public Company getCompany(long companyId) {
		Company company = companyRepository.findBycompanyId(companyId);
		return company;
	}

	@Override
	public String createCompany(Company company) {
		if (checkCompanyWhileRegistration(company.getCompanyName()) != null) {
			throw new DuplicateCompanyFoundException("Company already exists with : " + company.getCompanyName());
		}
		Users user = new Users();
		CharSequence password = null;
		Address companyAddress = company.getCompanyAddress();
		companyAddress = addressRepository.save(companyAddress);
		if (userRepository.findByUserName(company.getEmail()) == null) {
			user.setUserName(company.getEmail());
			password = passwordCreatorUtil.createPassword(company.getEmail());
			user.setPassword(passwordEncoder.encode(password));
			user.setRole(OWNER);
			userRepository.save(user);
		}
		company.setCompanyAddress(companyAddress);
		company.setUpdatedPerson(company.getUpdatedPerson());
		company.setUpdateTime(LocalDateTime.now());
		companyRepository.save(company);
		// Trigger the email after creating the company
		emailService.sendCompanyCreationEmail(company.getEmail(), company.getCompanyName(), user.getUserName(),
				password.toString());
		return "Company created successfully";
	}

	private Company checkCompanyWhileRegistration(String companyName) {
		Company company = companyRepository.findByCompanyName(companyName);
		return company;
	}

	@Override
	public CompanyResponse fetchCompanies() {
		List<Company> companyEntities = companyRepository.findAll();
		List<CompanyDTO> companyDTOs = companyEntities.stream()
				.map(company -> new CompanyDTO(company.getCompanyId(), company.getCompanyName())).toList();
		CompanyResponse response = new CompanyResponse();
		response.setCompanies(companyDTOs);
		return response;
	}

	@Override
	public StoreResponse fetchStores(String companyName) {

		Company company = checkCompany(companyName);

		List<Store> stores = storeService.getStoresUnderCompany(company);

		List<StoreDTO> storeDTOs = stores.stream()
				.map(store -> new StoreDTO(store.getDealerStoreId(), store.getStoreName())).toList();

		StoreResponse response = new StoreResponse();
		response.setStores(storeDTOs);
		return response;
	}

	@Override
	public Company checkCompany(String companyName) {
		Company company = companyRepository.findByCompanyName(companyName);
		if(company == null) {
			throw new CompanyNotFoundException("company with " + companyName + " not found");
		}
		return company;
	}

	@Override
	public Company isCompanyAvailable(String userName) {
		Company company = companyRepository.findByEmail(userName);
		return company;
	}
	
	

}
