package com.easydoers.employeeservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.easydoers.employeeservice.entity.Product;
import com.easydoers.employeeservice.entity.Store;
import com.easydoers.employeeservice.entity.StoreInventory;

@Repository
public interface StoreInventoryRepository extends JpaRepository<StoreInventory, Long>{

	StoreInventory findByStoreAndProduct(Store store, Product product);
	
	@Query("SELECT s FROM StoreInventory s WHERE s.quantity <= (s.minimumQuantity / 2)")
	List<StoreInventory> findLowStockInventories();
	
	@Query("SELECT s FROM StoreInventory s WHERE s.store = :store AND s.quantity <= (s.minimumQuantity / 2)")
	List<StoreInventory> findLowInventoryByStore(Store store);


}
