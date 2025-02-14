package com.easydoers.employeeservice.service;

import com.easydoers.employeeservice.entity.Invoice;
import com.easydoers.employeeservice.entity.Store;

public interface EmailService {

	void sendCompanyCreationEmail(String email, String companyName, String userName, String string);

	void sendManagerCredentialsEmail(String companyName,String managerName,String email, String password);

	void sendStoreInvoiceEmailToCompany(Store store, String email, Invoice invoice);

}
