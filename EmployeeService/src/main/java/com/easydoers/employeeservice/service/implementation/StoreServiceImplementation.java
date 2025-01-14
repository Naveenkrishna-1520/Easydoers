package com.easydoers.employeeservice.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.easydoers.employeeservice.entity.Store;
import com.easydoers.employeeservice.exception.StoreNotFoundException;
import com.easydoers.employeeservice.repository.StoreRepository;
import com.easydoers.employeeservice.service.StoreService;

@Service
public class StoreServiceImplementation implements StoreService{
	
	@Autowired
	private StoreRepository storeRepository;

	@Override
	public Store checkStore(String delaerStoreId) {

		Store store = storeRepository.findByDealerStoreId(delaerStoreId);
		if (store == null) {
			throw new StoreNotFoundException("store with " + delaerStoreId + " not found");
		}
		return store;

	}

}
