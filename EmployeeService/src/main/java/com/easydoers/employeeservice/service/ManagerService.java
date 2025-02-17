package com.easydoers.employeeservice.service;



import java.util.List;

import com.easydoers.employeeservice.dto.ManagerDetailsDTO;
import com.easydoers.employeeservice.entity.Manager;
import com.easydoers.employeeservice.entity.Store;

public interface ManagerService {

	String createManager(Manager manager);

	Manager checkManager(String managerName);

	Manager isManagerAvailable(String userName);

	String deleteManager(String managerEmail);

	ManagerDetailsDTO updateManager(Manager manager);

	List<Store> getStoresUnderManager(Manager manager);

}
