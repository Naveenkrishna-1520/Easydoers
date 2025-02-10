package com.easydoers.employeeservice.service.implementation;

import java.io.ByteArrayOutputStream;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.Month;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import com.easydoers.employeeservice.dto.PayslipResponse;
import com.easydoers.employeeservice.entity.Company;
import com.easydoers.employeeservice.entity.Employee;
import com.easydoers.employeeservice.entity.PayCheck;
import com.easydoers.employeeservice.entity.Sale;
import com.easydoers.employeeservice.entity.Work;
import com.easydoers.employeeservice.exception.payCheckGenerationException;
import com.easydoers.employeeservice.repository.PayCheckRepository;
import com.easydoers.employeeservice.service.CompanyService;
import com.easydoers.employeeservice.service.EmployeeService;
import com.easydoers.employeeservice.service.PayslipService;
import com.easydoers.employeeservice.service.SaleService;
import com.easydoers.employeeservice.service.WorkService;
import com.itextpdf.html2pdf.HtmlConverter;

@Service
public class PayslipServiceImplementation implements PayslipService {

	@Autowired
	private PayCheckRepository payCheckRepository;
	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private CompanyService companyService;
	@Autowired
	private WorkService workService;
	@Autowired
	private SaleService saleService;
	@Autowired
	private TemplateEngine templateEngine;

	@Override
	public Map<byte[], PayslipResponse> generatePayslipForEmployee(String employeeNtid, LocalDate start,
			LocalDate end) {
		Map<byte[], PayslipResponse> result = new HashMap<>();
		PayslipResponse response = new PayslipResponse();
		Employee employee = employeeService.checkEmployee(employeeNtid);
		Company company = companyService.getCompany(employee.getCompany().getCompanyId());
		double numberOfHoursWorked = 0.0d;
		int numberOfBoxesSold = 0;
		double accessoriesMakeByEmployee = 0.0d;
		int numberOfWorkingDays = 0;
		List<Work> works = workService.getWorksByEmployeeAndDateRange(employee.getEmployeeId(), start, end);
		for (Work work : works) {
			numberOfHoursWorked = numberOfHoursWorked + work.getNumberOfHoursWorkedByEmployee();
		}
		List<Sale> listOfSales = saleService.getEmployeeSales(employee.getEmployeeId(), start, end);
		for (Sale sale : listOfSales) {
			if (sale != null) {
				numberOfWorkingDays++;
				numberOfBoxesSold = numberOfBoxesSold + sale.getBoxesSold() - sale.getTabletsSold()
						- sale.getWatchesSold();
				accessoriesMakeByEmployee = accessoriesMakeByEmployee + sale.getAccessories();
			}
		}
		double boxesCommissionEarnedByEmployee = numberOfBoxesSold * employee.getPerBoxCommission();
		double accessoriesCommisionEarnedByEmployee = accessoriesMakeByEmployee
				* (employee.getCommissionPercentage() * 0.01);
		double workingHoursPay = numberOfHoursWorked * employee.getEmployeePayRatePerHour();
		BigDecimal roundedPay = getRoundedValue(workingHoursPay);
		workingHoursPay = roundedPay.doubleValue();

		double netPay = workingHoursPay + boxesCommissionEarnedByEmployee + accessoriesCommisionEarnedByEmployee;
		BigDecimal roundedNetPay = getRoundedValue(netPay);
		netPay = roundedNetPay.doubleValue();
		PayCheck payCheck = new PayCheck();
		List<PayCheck> checkPayGenerated = payCheckRepository.findByEmployeeAndMonthAndYear(employee,
				start.getMonthValue(), start.getYear());
		if (checkPayGenerated.isEmpty()) {
			payCheck.setAccessoriesCommission(accessoriesCommisionEarnedByEmployee);
			payCheck.setBoxesCommission(boxesCommissionEarnedByEmployee);
			payCheck.setEmployee(employee);
			payCheck.setTotalEarnedByEmployee(netPay);
			payCheck.setPayCheckStartDate(start);
			payCheck.setPayCheckEndDate(end);
			payCheck.setMonth(start.getMonthValue());
			payCheck.setYear(start.getYear());
			payCheck.setPayGeneratedDate(LocalDate.now());
			payCheckRepository.save(payCheck);
		} else {
			for (PayCheck payCheckValidation : checkPayGenerated) {

				if (start.getDayOfMonth() > payCheckValidation.getPayCheckEndDate().getDayOfMonth()
						&& end.getDayOfMonth() < payCheckValidation.getPayCheckStartDate().getDayOfMonth()) {
					payCheck.setAccessoriesCommission(accessoriesCommisionEarnedByEmployee);
					payCheck.setBoxesCommission(boxesCommissionEarnedByEmployee);
					payCheck.setEmployee(employee);
					payCheck.setTotalEarnedByEmployee(netPay);
					payCheck.setPayCheckStartDate(start);
					payCheck.setPayCheckEndDate(end);
					payCheck.setMonth(start.getMonthValue());
					payCheck.setYear(start.getYear());
					payCheck.setPayGeneratedDate(LocalDate.now());
				} else if (start.getDayOfMonth() == payCheckValidation.getPayCheckStartDate().getDayOfMonth()
						&& end.getDayOfMonth() == payCheckValidation.getPayCheckEndDate().getDayOfMonth()) {
					continue;
				} else {
				}
				throw new payCheckGenerationException("Employee with " + employee.getEmployeeNtid()
						+ " last pay generated :" + payCheckValidation.getPayGeneratedDate() + " form date :"
						+ payCheckValidation.getPayCheckStartDate() + " to " + payCheckValidation.getPayCheckEndDate()
						+ " modify the dates and generate again");
			}
		}
		Map<String, Object> payslipDetails = getPayslipDetails(employee.getEmployeeName(), employeeNtid,
				numberOfBoxesSold, numberOfHoursWorked, netPay, company.getCompanyName(), start.getMonth(),
				start.getYear(), boxesCommissionEarnedByEmployee, accessoriesCommisionEarnedByEmployee, workingHoursPay,
				numberOfWorkingDays);

		// Populate Thymeleaf context
		Context context = new Context();
		context.setVariables(payslipDetails);
		String htmlContent = templateEngine.process("payslip", context);
		// Generate PDF in memory
		ByteArrayOutputStream pdfOutputStream = new ByteArrayOutputStream();
		HtmlConverter.convertToPdf(htmlContent, pdfOutputStream);
		response.setPaySlip(employeeNtid + "payslip.pdf");
		result.put(pdfOutputStream.toByteArray(), response);
		return result;
	}

	private BigDecimal getRoundedValue(double value) {
		return BigDecimal.valueOf(value).setScale(2, RoundingMode.HALF_UP);
	}

	private Map<String, Object> getPayslipDetails(String employeeName, String employeeNtid, int numberOfBoxesSold,
			double numberOfHoursWorked, double netPay, String companyName, Month month, int year,
			double boxesCommissionEarnedByEmployee, double accessoriesCommisionEarnedByEmployee, double workingHoursPay,
			int numberOfWorkingDays) {
		Map<String, Object> payslipDetails = new HashMap<>();
		payslipDetails.put("companyName", companyName);
		payslipDetails.put("employeeName", employeeName);
		payslipDetails.put("employeeNtid", employeeNtid);
		payslipDetails.put("hoursWorked", numberOfHoursWorked);
		payslipDetails.put("workingHoursPay", workingHoursPay);
		payslipDetails.put("taxes", "0.00");
		payslipDetails.put("federalTax", "0.00");
		payslipDetails.put("totalDeductions", "0.00");
		payslipDetails.put("stateTax", "0.00");
		payslipDetails.put("totalEarnings", netPay);
		payslipDetails.put("paidDate", LocalDate.now());
		payslipDetails.put("netPay", netPay);
		payslipDetails.put("month", month);
		payslipDetails.put("year", year);
		payslipDetails.put("boxesCommission", boxesCommissionEarnedByEmployee);
		payslipDetails.put("accessoriesCommission", accessoriesCommisionEarnedByEmployee);
		payslipDetails.put("noOfWorkingDays", numberOfWorkingDays);
		return payslipDetails;
	}

}
