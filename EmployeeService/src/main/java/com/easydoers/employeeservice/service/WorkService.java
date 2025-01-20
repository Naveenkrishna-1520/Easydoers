package com.easydoers.employeeservice.service;

import java.time.LocalDate;
import java.util.List;

import com.easydoers.employeeservice.dto.ClockinResponse;
import com.easydoers.employeeservice.entity.Employee;
import com.easydoers.employeeservice.entity.Store;
import com.easydoers.employeeservice.entity.Work;


public interface WorkService {

	void saveWorkForEmployee(Long employeeId, LocalDate now);

	Work findByEmployeeAndDateInWork(Long employeeId, LocalDate now);

	ClockinResponse findByEmployeeInWork(Employee employee, LocalDate now, Store store);

	Work checkClockinStatus(Long employeeId, LocalDate now);

	List<Work> getWorksByEmployeeAndDateRange(Long employeeId, LocalDate start, LocalDate end);

}
