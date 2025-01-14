package com.easydoers.employeeservice.service.implementation;

import java.text.DecimalFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.easydoers.employeeservice.dto.ClockinResponse;
import com.easydoers.employeeservice.entity.Employee;
import com.easydoers.employeeservice.entity.Store;
import com.easydoers.employeeservice.entity.Work;
import com.easydoers.employeeservice.exception.SavingEmployeeWorkException;
import com.easydoers.employeeservice.repository.WorkRepository;
import com.easydoers.employeeservice.service.WorkService;

@Service
public class WorkServiceImplementation implements WorkService {

	@Autowired
	private WorkRepository workRepository;

	@Override
	public void saveWorkForEmployee(Long employeeId, LocalDate now) {
		Work work = findByEmployeeAndDateInWork(employeeId, now);
		work.setClockOutTime(LocalTime.now());
		work.setNumberOfHoursWorkedByEmployee(
				calculateNumberOfWorkedByEmployee(work.getClockOutTime(), work.getClockInTime()));
		workRepository.save(work);
	}

	public Work findByEmployeeAndDateInWork(Long employeeId, LocalDate now) {
		Work work = workRepository.findByEmployeeIdAndDate(employeeId, LocalDate.now());
		if (work == null) {
			throw new SavingEmployeeWorkException("issue while saving work");
		}
		return work;
	}

	private double calculateNumberOfWorkedByEmployee(LocalTime clockOutTime, LocalTime clockInTime) {
		Duration numberOfWorkedByEmployee = Duration.between(clockInTime, clockOutTime);
		double hoursWorked = numberOfWorkedByEmployee.toMinutes() / 60.0;
		DecimalFormat format = new DecimalFormat("#.##");
		double roundedValueForHoursWorked = Double.parseDouble(format.format(hoursWorked));
		return roundedValueForHoursWorked;
	}

	@Override
	public ClockinResponse findByEmployeeInWork(Employee employee, LocalDate now, Store store) {
		ClockinResponse response = new ClockinResponse();
		Work work = workRepository.findByEmployeeIdAndDate(employee.getEmployeeId(), LocalDate.now());
		if (work == null) {
			Work workRequset = new Work();
			workRequset.setEmployee(employee);
			workRequset.setStore(store);
			workRequset.setClockInTime(LocalTime.now());
			workRequset.setDate(LocalDate.now());
			workRepository.save(workRequset);
			response.setClockin(true);
			return response;
		}
		return response;
	}

}
