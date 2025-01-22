package com.easydoers.employeeservice.repository;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.easydoers.employeeservice.entity.Employee;
import com.easydoers.employeeservice.entity.Store;
import com.easydoers.employeeservice.entity.UpgradePhonesInvoice;

@Repository
public interface UpgradePhonesInvoiceRepository extends JpaRepository<UpgradePhonesInvoice, Long>{

	UpgradePhonesInvoice findByEmployeeAndStoreAndActivatedDate(Employee employee, Store store,
			LocalDate activatedDate);

}
