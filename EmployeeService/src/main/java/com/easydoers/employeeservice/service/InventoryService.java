package com.easydoers.employeeservice.service;




import java.util.Map;

import com.easydoers.employeeservice.dto.AddMinimumInventoryRequest;
import com.easydoers.employeeservice.dto.StoreInventoryDTO;
import com.easydoers.employeeservice.dto.UpdateInventoryRequest;

public interface InventoryService {


	StoreInventoryDTO getStoreInventory(String dealerStoreId);

	Map<String, Object> addMinimumInventoryToStores(AddMinimumInventoryRequest inventoryRequest);

	Map<String, Object> updateInventoryToStores(UpdateInventoryRequest inventoryRequest);
	

}
