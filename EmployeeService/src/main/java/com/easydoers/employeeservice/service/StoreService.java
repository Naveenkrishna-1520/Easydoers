package com.easydoers.employeeservice.service;

import java.util.List;

import com.easydoers.employeeservice.entity.Company;
import com.easydoers.employeeservice.entity.Manager;
import com.easydoers.employeeservice.entity.Store;

public interface StoreService {

	Store checkStore(String dealerStoreId);

	List<Store> getStoresUnderCompany(Company company);

	String createStore(Store store);

	String assignManagerToStores(String dealerStoreId, String managerName);

	String deleteStore(String dealerStoreId);

	List<Store> getStoresUnderManager(Manager manager);

}
