package com.easydoers.employeeservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.easydoers.employeeservice.entity.Store;


@Repository
public interface StoreRepository extends JpaRepository<Store, String>{

	Store findByDealerStoreId(String dealerStoreId);

}
