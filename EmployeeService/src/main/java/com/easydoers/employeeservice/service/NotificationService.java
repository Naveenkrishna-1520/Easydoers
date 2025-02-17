package com.easydoers.employeeservice.service;

import com.easydoers.employeeservice.dto.InventoryAlertDTO;

public interface NotificationService {

	void sendInventoryAlert(InventoryAlertDTO alert, String managerEmail);

}
