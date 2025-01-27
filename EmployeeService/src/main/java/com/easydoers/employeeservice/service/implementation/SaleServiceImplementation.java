package com.easydoers.employeeservice.service.implementation;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.easydoers.employeeservice.dto.EmployeeSalesDTO;
import com.easydoers.employeeservice.dto.SaleDTO;
import com.easydoers.employeeservice.dto.SaleRequest;
import com.easydoers.employeeservice.entity.Employee;
import com.easydoers.employeeservice.entity.Sale;
import com.easydoers.employeeservice.entity.Store;
import com.easydoers.employeeservice.exception.NoSalesFound;
import com.easydoers.employeeservice.repository.SaleRepository;
import com.easydoers.employeeservice.service.EmployeeService;
import com.easydoers.employeeservice.service.SaleService;
import com.easydoers.employeeservice.service.StoreService;
import com.easydoers.employeeservice.service.WorkService;

@Service
public class SaleServiceImplementation implements SaleService{
	
	@Autowired
	private EmployeeService employeeService;
	@Autowired
	private StoreService storeService;
	@Autowired
	private SaleRepository saleRepository;
	@Autowired
	private WorkService workService;

	@Override
	public String saveSaleDetails(String employeeNTId, String dealerStoreId, SaleRequest saleRequest) {

		return saveEndOfTheDaySaleReportEnteredByEmployee(saleRequest, employeeNTId, dealerStoreId);
	}

	private String saveEndOfTheDaySaleReportEnteredByEmployee(SaleRequest saleRequest, String employeeNTId,
			String dealerStoreId) {
		Employee employee = employeeService.checkEmployee(employeeNTId);
		Store store = storeService.checkStore(dealerStoreId);
		Sale saleCheck = checkSaleSubmittedByEmployee(employee.getEmployeeId(), LocalDate.now());
		if (saleCheck == null) {
			Sale saveSaleDetails = new Sale();
			saveSaleDetails.setEmployee(employee);
			saveSaleDetails.setStore(store);
			saveSaleDetails.setSystemAccessories(saleRequest.getSystemAccessories());
			saveSaleDetails.setAccessories(calculateAccessoriesForEmployeee(saleRequest.getSystemCard(),
					saleRequest.getSystemCash(), saleRequest.getActualCard(), saleRequest.getActualCash(), saleRequest.getSystemAccessories()));
			saveSaleDetails.setBoxesSold(saleRequest.getBoxesSold());
			saveSaleDetails.setTabletsSold(saleRequest.getTabletsSold());
			saveSaleDetails.setHsiSold(saleRequest.getHsiSold());
			saveSaleDetails.setWatchesSold(saleRequest.getWatchesSold());
			saveSaleDetails.setSystemCash(saleRequest.getSystemCash());
			saveSaleDetails.setSystemCard(saleRequest.getSystemCard());
			saveSaleDetails.setActualCash(saleRequest.getActualCash());
			saveSaleDetails.setActualCard(saleRequest.getActualCard());
			saveSaleDetails.setCashExpense(saleRequest.getCashExpense());
			saveSaleDetails.setExpenseReason(saleRequest.getExpenseReason());
			saveSaleDetails.setSaleDate(LocalDate.now());
			saleRepository.save(saveSaleDetails);
			workService.saveWorkForEmployee(employee.getEmployeeId(), LocalDate.now());
			return employee.getEmployeeNtid() + " : Saved End Of The Day Report Successfully ";
		}

		return employee.getEmployeeName() + " : " + employee.getEmployeeNtid()
				+ " Already Saved End Of The Sale Report " + saleRepository.findBySaleId(saleCheck.getSaleId());
	}

	public Sale checkSaleSubmittedByEmployee(Long employeeId, LocalDate now) {
		
		return saleRepository.findByEmployeeIdAndDate(employeeId, LocalDate.now());
	}

	private double calculateAccessoriesForEmployeee(double systemCard, double systemCash, double actualCard,
			double actualCash, double systemAccessories) {
		double totalAccessoriesByEmployeeInCashAndCard = (actualCard - systemCard) + (actualCash - systemCash) +systemAccessories;
		return totalAccessoriesByEmployeeInCashAndCard;
	}

	@Override
	public EmployeeSalesDTO getEmployeeSales(String employeeNtid) {
		System.out.println(LocalDateTime.now());
		Employee employee = employeeService.checkEmployee(employeeNtid);
		List<SaleDTO> salesByEmployee = checkSalesForEmployee(employee);
		return new EmployeeSalesDTO(employee.getEmployeeNtid(), employee.getEmployeeName(), salesByEmployee);
	}

	public List<SaleDTO> checkSalesForEmployee(Employee employee){
		
		List<SaleDTO> salesByEmployee = saleRepository.findSalesByEmployeeId(employee.getEmployeeId());
		if(salesByEmployee.isEmpty()) {
			throw new NoSalesFound("no sales found for : "+employee.getEmployeeNtid());
		}
		return salesByEmployee;
		
	}

	@Override
	public List<Sale> getEmployeeSales(Long employeeId, LocalDate start, LocalDate end) {
		return saleRepository.findSalesByEmployeeIdAndDateRange(employeeId, start, end);
	}

}
