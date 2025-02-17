package com.easydoers.employeeservice.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import com.easydoers.employeeservice.dto.InventoryAlertDTO;
import com.easydoers.employeeservice.service.NotificationService;

@Service
public class NotificationServiceImplementation implements NotificationService{

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    public void sendInventoryAlert(InventoryAlertDTO alert, String managerEmail) {
        messagingTemplate.convertAndSend("/topic/InventoryAlerts/" + managerEmail, alert);
    }
}
