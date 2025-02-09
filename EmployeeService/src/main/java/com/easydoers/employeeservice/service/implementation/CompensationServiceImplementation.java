package com.easydoers.employeeservice.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.easydoers.employeeservice.entity.Compensation;
import com.easydoers.employeeservice.repository.CompensationRepository;
import com.easydoers.employeeservice.service.CompensationService;

@Service
public class CompensationServiceImplementation implements CompensationService{
	
	@Autowired
	private CompensationRepository compensationRepository;

	@Override
	public String saveCompensation(Compensation compensation) {
		compensationRepository.save(compensation);
		return "Compensation saved successfully";
	}

}
