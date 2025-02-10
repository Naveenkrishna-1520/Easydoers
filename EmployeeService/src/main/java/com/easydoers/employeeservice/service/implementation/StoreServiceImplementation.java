package com.easydoers.employeeservice.service.implementation;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import com.easydoers.employeeservice.entity.Address;
import com.easydoers.employeeservice.entity.Company;
import com.easydoers.employeeservice.entity.Store;
import com.easydoers.employeeservice.exception.DuplicateUserFoundException;
import com.easydoers.employeeservice.exception.StoreNotFoundException;
import com.easydoers.employeeservice.repository.AddressRepository;
import com.easydoers.employeeservice.repository.StoreRepository;
import com.easydoers.employeeservice.service.CompanyService;
import com.easydoers.employeeservice.service.StoreService;

@Service
public class StoreServiceImplementation implements StoreService {

	@Autowired
	private StoreRepository storeRepository;
	@Autowired
	private AddressRepository addressRepository;
	@Autowired
	@Lazy
	private CompanyService companyService;


	@Override
	public Store checkStore(String dealerStoreId) {

		Store store = storeRepository.findByDealerStoreId(dealerStoreId);

		if (store == null) {
			throw new StoreNotFoundException("store with " + dealerStoreId + " not found");
		}

		return store;

	}

	@Override
	public List<Store> getStoresUnderCompany(Company company) {
		return storeRepository.findByCompany(company);
	}

	@Override
	public String createStore(Store store) {
		if (checkEmployeeWhileRegistration(store.getDealerStoreId()) != null) {
			throw new DuplicateUserFoundException("Store already exists with : " + store.getDealerStoreId());
		}

		Address storeAddress = addressRepository.save(store.getAddress());
		Company company = companyService.checkCompany(store.getCompany().getCompanyName());
		store.setAddress(storeAddress);
		store.setCompany(company);
		storeRepository.save(store);
		return "Store created successfully";
	}

	private Store checkEmployeeWhileRegistration(String dealerStoreId) {
		Store store = storeRepository.findByDealerStoreId(dealerStoreId);
		return store;
	}

}
