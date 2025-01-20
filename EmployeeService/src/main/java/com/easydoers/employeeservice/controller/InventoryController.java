package com.easydoers.employeeservice.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.easydoers.employeeservice.dto.AddMinimumInventoryRequest;
import com.easydoers.employeeservice.dto.StoreInventoryDTO;
import com.easydoers.employeeservice.dto.UpdateInventoryRequest;
import com.easydoers.employeeservice.service.InventoryService;

@RestController
@RequestMapping("v1/inventory")
public class InventoryController {

	@Autowired
	private InventoryService inventoryService;

	@GetMapping("/store")
	public ResponseEntity<StoreInventoryDTO> getInventoryByStoreId(
			@RequestParam("dealerStoreId") String dealerStoreId) {
		StoreInventoryDTO response = inventoryService.getStoreInventory(dealerStoreId);
		return ResponseEntity.ok().body(response);

	}

	@PostMapping("/addInventory")
	public ResponseEntity<Map<String, Object>> addMinimumInventoryToStores(
			@RequestBody AddMinimumInventoryRequest inventoryRequest) {
		Map<String, Object> response = inventoryService.addMinimumInventoryToStores(inventoryRequest);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);

	}
	
	@PutMapping("/updateInventory")
	public ResponseEntity<Map<String, Object>> updateInventory(
			@RequestBody UpdateInventoryRequest inventoryRequest) {
		Map<String, Object> response = inventoryService.updateInventoryToStores(inventoryRequest);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);

	}
}
