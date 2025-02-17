package com.easydoers.employeeservice.service.implementation;


import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.easydoers.employeeservice.dto.StoreDTO;
import com.easydoers.employeeservice.dto.StoreTargetResponse;
import com.easydoers.employeeservice.entity.Company;
import com.easydoers.employeeservice.entity.Manager;
import com.easydoers.employeeservice.entity.Store;
import com.easydoers.employeeservice.entity.StoreTarget;
import com.easydoers.employeeservice.exception.targetExistedException;
import com.easydoers.employeeservice.repository.StoreTargetRepository;
import com.easydoers.employeeservice.service.CompanyService;
import com.easydoers.employeeservice.service.ManagerService;
import com.easydoers.employeeservice.service.StoreService;
import com.easydoers.employeeservice.service.StoreTargetService;

@Service
public class StoreTargetServiceImplementation implements StoreTargetService {

	@Autowired
	private StoreTargetRepository storeTargetRepository;
	@Autowired
	private StoreService storeService;
	@Autowired
	private CompanyService companyService;
	@Autowired
	private ManagerService managerService;

	@Override
	public String setStoreTarget(StoreTarget storeTarget) {

		Store store = storeService.checkStore(storeTarget.getStore().getDealerStoreId());
		StoreTarget targetForMonth = storeTargetRepository.findByStoreAndTargetMonth(store,
				storeTarget.getTargetMonth());
		if (targetForMonth == null) {
			storeTarget.setStore(store);
			storeTargetRepository.save(storeTarget);

		} else {
			throw new targetExistedException(store.getDealerStoreId() + " target for the month "
					+ storeTarget.getTargetMonth() + " is already existed");
		}

		return "Store target is successfully saved";
	}

	@Override
	public List<StoreTargetResponse> getAllStoreTargets(String companyName, String targetMonth) {
		
		Company company = companyService.checkCompany(companyName);
		List<Store> stores = storeService.getStoresUnderCompany(company);
		YearMonth month = YearMonth.parse(targetMonth);
		List<StoreTargetResponse> StoreTargetResponse = fetchTargets(stores, month);
		return StoreTargetResponse;
		
	}

	private List<StoreTargetResponse> fetchTargets(List<Store> stores, YearMonth month) {
		List<StoreTargetResponse> StoreTargetResponse = new ArrayList<>();
		for (Store store : stores) {
			StoreTarget storeTarget = storeTargetRepository.findByStoreAndTargetMonth(store, month);
			StoreDTO storeDTO = new StoreDTO(store.getDealerStoreId(), store.getStoreName());
			if(storeTarget!=null) {
			StoreTargetResponse response = new StoreTargetResponse(storeTarget.getTargetId(),
					storeTarget.getActivationTargetToStore(), storeTarget.getAccessoriesTargetToStore(),
					storeTarget.getHsiTargetToStore(), storeTarget.getTabletsTargetToStore(),
					storeTarget.getSmartwatchTragetToStore(), storeTarget.getTargetMonth().toString(), storeDTO);
			StoreTargetResponse.add(response);
			}
		}
		return StoreTargetResponse;
	}

	@Override
	public List<StoreTargetResponse> getAllStoreTargetsForManager(String managerName, String targetMonth) {
		Manager manager = managerService.checkManager(managerName);
		List<Store> stores = managerService.getStoresUnderManager(manager);
		YearMonth month = YearMonth.parse(targetMonth);
		List<StoreTargetResponse> StoreTargetResponse = fetchTargets(stores, month);
		return StoreTargetResponse;
	}

}
