package com.easydoers.employeeservice.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.easydoers.employeeservice.dto.SaleDTO;
import com.easydoers.employeeservice.entity.Sale;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Long> {

	
	@Query("SELECT new com.easydoers.employeeservice.dto.SaleDTO(s.saleId, s.boxesSold,s.systemAccessories, s.accessories, " +
		       "s.tabletsSold, s.hsiSold, s.watchesSold, s.systemCash, s.systemCard, " +
		       "s.actualCash, s.actualCard, s.cashExpense, s.expenseReason, s.saleDate, " +
		       "new com.easydoers.employeeservice.dto.StoreDTO(st.dealerStoreId, st.storeName)) " +
		       "FROM Sale s JOIN s.store st WHERE s.employee.id = :employeeId")
		List<SaleDTO> findSalesByEmployeeId(@Param("employeeId") Long employeeId);

	@Query("SELECT s FROM Sale s WHERE s.employee.id = :employeeId AND DATE(s.saleDate) = :saleDate")
	Sale findByEmployeeIdAndDate(Long employeeId, LocalDate saleDate);

	@Query("SELECT new com.easydoers.employeeservice.dto.SaleDTO(s.saleId, s.boxesSold,s.systemAccessories, s.accessories, " +
		       "s.tabletsSold, s.hsiSold, s.watchesSold, s.systemCash, s.systemCard, " +
		       "s.actualCash, s.actualCard, s.cashExpense, s.expenseReason, s.saleDate, " +
		       "new com.easydoers.employeeservice.dto.StoreDTO(st.dealerStoreId, st.storeName)) " +
		       "FROM Sale s JOIN s.store st WHERE s.saleId = :saleId")
	SaleDTO findBySaleId(Long saleId);
	
	@Query("SELECT s FROM Sale s WHERE s.employee.employeeId = :employeeId AND s.saleDate BETWEEN :start AND :end")
	List<Sale> findSalesByEmployeeIdAndDateRange(@Param("employeeId") Long employeeId,
	                                             @Param("start") LocalDate start,
	                                             @Param("end") LocalDate end);



}
