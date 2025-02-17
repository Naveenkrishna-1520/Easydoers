package com.easydoers.employeeservice.service.implementation;

import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.easydoers.employeeservice.dto.EmployeeDTO;
import com.easydoers.employeeservice.dto.EmployeeTargetResponse;
import com.easydoers.employeeservice.entity.Company;
import com.easydoers.employeeservice.entity.Employee;
import com.easydoers.employeeservice.entity.EmployeeTarget;
import com.easydoers.employeeservice.exception.targetExistedException;
import com.easydoers.employeeservice.repository.EmployeeTargetRepository;
import com.easydoers.employeeservice.service.CompanyService;
import com.easydoers.employeeservice.service.EmployeeService;
import com.easydoers.employeeservice.service.EmployeeTargetService;

@Service
public class EmployeeTargetServiceImplementation implements EmployeeTargetService {

	@Autowired
	private EmployeeTargetRepository employeeTargetRepository;
	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private CompanyService companyService;

	@Override
	public String setEmployeeTarget(EmployeeTarget employeeTarget) {

		Employee employee = employeeService.checkEmployee(employeeTarget.getEmployee().getEmployeeNtid());
		EmployeeTarget targetForMonth = employeeTargetRepository.findByEmployeeAndTargetMonth(employee,
				employeeTarget.getTargetMonth());
		if (targetForMonth == null) {
			employeeTarget.setEmployee(employee);
			employeeTargetRepository.save(employeeTarget);

		} else {
			throw new targetExistedException(employee.getEmployeeNtid() + " target for the month "
					+ employeeTarget.getTargetMonth() + " is already existed");
		}

		return "Employee target saved successfully";
	}

	@Override
	public List<EmployeeTargetResponse> getAllEmployeeTargets(String companyName, String targetMonth) {
		List<EmployeeTargetResponse> employeeTargetResponse = new ArrayList<>();
		Company company = companyService.checkCompany(companyName);
		List<Employee> employees = employeeService.getEmployeesUnderCompany(company);
		YearMonth month = YearMonth.parse(targetMonth);
		for (Employee employee : employees) {
			EmployeeTarget employeeTarget = employeeTargetRepository.findByEmployeeAndTargetMonth(employee, month);
			EmployeeDTO employeeDTO = new EmployeeDTO(employee.getEmployeeNtid(), employee.getEmployeeName());
			if (employeeTarget != null) {
				EmployeeTargetResponse response = new EmployeeTargetResponse(employeeTarget.getTargetId(),
						employeeTarget.getPhonesTargetToEmployee(), employeeTarget.getAccessoriesTargetByEmployee(),
						employeeTarget.getHsiTarget(), employeeTarget.getTabletsTargetByEmployee(),
						employeeTarget.getSmartwatchTragetByEmployee(), employeeTarget.getTargetMonth().toString(),
						employeeDTO);
				employeeTargetResponse.add(response);
			}
		}

		return employeeTargetResponse;
	}

}
