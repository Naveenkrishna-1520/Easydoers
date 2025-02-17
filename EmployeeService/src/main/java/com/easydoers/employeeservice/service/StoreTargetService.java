package com.easydoers.employeeservice.service;


import java.util.List;

import com.easydoers.employeeservice.dto.StoreTargetResponse;
import com.easydoers.employeeservice.entity.StoreTarget;

public interface StoreTargetService {

	String setStoreTarget(StoreTarget storeTarget);

	List<StoreTargetResponse> getAllStoreTargets(String companyName, String targetMonth);

	List<StoreTargetResponse> getAllStoreTargetsForManager(String managerName, String targetMonth);

}
