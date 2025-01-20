package com.easydoers.employeeservice.service.implementation;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.easydoers.employeeservice.dto.AddMinimumInventoryRequest;
import com.easydoers.employeeservice.dto.ProductDTO;
import com.easydoers.employeeservice.dto.StoreInventoryDTO;
import com.easydoers.employeeservice.dto.UpdateInventoryRequest;
import com.easydoers.employeeservice.entity.Product;
import com.easydoers.employeeservice.entity.Store;
import com.easydoers.employeeservice.entity.StoreInventory;
import com.easydoers.employeeservice.repository.InventoryRepository;
import com.easydoers.employeeservice.repository.StoreInventoryRepository;
import com.easydoers.employeeservice.service.InventoryService;
import com.easydoers.employeeservice.service.ProductService;
import com.easydoers.employeeservice.service.StoreService;

@Service
public class InventoryServiceImplementation implements InventoryService {

	@Autowired
	private InventoryRepository inventoryRepository;
	@Autowired
	private StoreService storeService;
	@Autowired
	private StoreInventoryRepository storeInventoryRepository;
	@Autowired
	private ProductService productService;

	@Override
	public StoreInventoryDTO getStoreInventory(String dealerStoreId) {
		Store store = storeService.checkStore(dealerStoreId);
		List<ProductDTO> products = inventoryRepository.findProductsByStoreId(store.getStoreId());
		return new StoreInventoryDTO(products);
	}

	@Override
	public Map<String, Object> addMinimumInventoryToStores(AddMinimumInventoryRequest inventoryRequest) {
		Store store = storeService.checkStore(inventoryRequest.getDealerStoreId());
		for (ProductDTO product : inventoryRequest.getProducts()) {
			StoreInventory storeInventory = new StoreInventory();
			Product getProduct = productService.checkProduct(product.getProductName());
			StoreInventory checkStoreInventory = storeInventoryRepository.findByStoreAndProduct(store, getProduct);
			if (checkStoreInventory == null) {
				storeInventory.setStore(store);
				storeInventory.setProduct(getProduct);
				storeInventory.setMinimumQuantity(product.getQuantity());
				storeInventoryRepository.save(storeInventory);
			} else {
				checkStoreInventory.setMinimumQuantity(product.getQuantity());
				storeInventoryRepository.save(checkStoreInventory);
			}

		}
		Map<String, Object> response = new HashMap<>();
		response.put("timestamp : ", LocalDateTime.now());
		response.put("message : ", "adding minimum inventory requirement for store : "
				+ inventoryRequest.getDealerStoreId() + " is successfuly done");
		return response;
	}

	@Override
	public Map<String, Object> updateInventoryToStores(UpdateInventoryRequest inventoryRequest) {
		Store store = storeService.checkStore(inventoryRequest.getDealerStoreId());
		for (ProductDTO product : inventoryRequest.getProducts()) {
			Product getProduct = productService.checkProduct(product.getProductName());
			StoreInventory checkStoreInventory = storeInventoryRepository.findByStoreAndProduct(store, getProduct);
			if (checkStoreInventory != null) {
				checkStoreInventory.setQuantity(product.getQuantity());
				storeInventoryRepository.save(checkStoreInventory);
			}
		}
		Map<String, Object> response = new HashMap<>();
		response.put("timestamp : ", LocalDateTime.now());
		response.put("message : ",
				"updating inventory for store : " + inventoryRequest.getDealerStoreId() + " is successfuly done");
		return response;
	}

}
