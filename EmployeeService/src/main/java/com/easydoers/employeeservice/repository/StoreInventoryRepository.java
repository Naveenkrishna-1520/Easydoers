package com.easydoers.employeeservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.easydoers.employeeservice.entity.Product;
import com.easydoers.employeeservice.entity.Store;
import com.easydoers.employeeservice.entity.StoreInventory;

@Repository
public interface StoreInventoryRepository extends JpaRepository<StoreInventory, Long>{

	StoreInventory findByStoreAndProduct(Store store, Product product);

}
