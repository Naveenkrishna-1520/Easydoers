package com.easydoers.employeeservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.easydoers.employeeservice.entity.Company;
import com.easydoers.employeeservice.entity.Store;


@Repository
public interface StoreRepository extends JpaRepository<Store, Long>{

	Store findByDealerStoreId(String dealerStoreId);

	List<Store> findByCompany(Company company);

}
