package com.easydoers.employeeservice.service;



import com.easydoers.employeeservice.entity.Manager;

public interface ManagerService {

	String createManager(Manager manager);

	Manager checkManager(String managerName);

}
