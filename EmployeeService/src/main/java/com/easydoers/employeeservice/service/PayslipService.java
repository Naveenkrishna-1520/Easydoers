package com.easydoers.employeeservice.service;

import java.time.LocalDate;
import java.util.Map;

import com.easydoers.employeeservice.dto.PayslipResponse;

public interface PayslipService {


	Map<byte[], PayslipResponse> generatePayslipForEmployee(String employeeNtid, LocalDate start, LocalDate end);

}
