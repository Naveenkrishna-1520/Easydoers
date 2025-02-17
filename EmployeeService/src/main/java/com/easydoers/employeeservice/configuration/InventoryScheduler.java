package com.easydoers.employeeservice.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.easydoers.employeeservice.service.InventoryService;

@Component
public class InventoryScheduler {

	@Autowired
	private InventoryService inventoryService;

	@Scheduled(cron = "0 0 12 * * ?")  // Runs daily at 12 PM (Noon)
	public void scheduleLowInventoryCheck() {
		inventoryService.checkLowInventoryAndNotify();
	}
}
