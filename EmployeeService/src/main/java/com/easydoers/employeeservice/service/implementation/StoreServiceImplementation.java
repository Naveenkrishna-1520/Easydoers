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
	public Store checkStore(String dealerStoreId) {

		Store store = storeRepository.findByDealerStoreId(dealerStoreId);
		if (store == null) {
			throw new StoreNotFoundException("store with " + dealerStoreId + " not found");
		}
		return store;

	}

}
