package com.easydoers.employeeservice.service;




import java.util.List;
import java.util.Map;

import com.easydoers.employeeservice.dto.AddMinimumInventoryRequest;
import com.easydoers.employeeservice.dto.DeleteProductRequest;
import com.easydoers.employeeservice.dto.ReorderSummaryResponse;
import com.easydoers.employeeservice.dto.StoreInventoryDTO;
import com.easydoers.employeeservice.dto.UpdateInventoryRequest;

public interface InventoryService {


	StoreInventoryDTO getStoreInventory(String dealerStoreId);

	Map<String, Object> addMinimumInventoryToStores(AddMinimumInventoryRequest inventoryRequest);

	Map<String, Object> updateInventoryToStores(UpdateInventoryRequest inventoryRequest);

	Map<String, Object> deleteInventoryfromStore(DeleteProductRequest deleteProductRequest);

	void checkLowInventoryAndNotify();

	List<ReorderSummaryResponse> fetchStoresReorderSummaryForCompany(String companyName);

	List<ReorderSummaryResponse> fetchStoresReorderSummary(String managerName);
	

}
