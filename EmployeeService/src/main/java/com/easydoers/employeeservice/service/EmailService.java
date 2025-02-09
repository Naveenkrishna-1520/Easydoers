package com.easydoers.employeeservice.service;

public interface EmailService {

	void sendCompanyCreationEmail(String email, String companyName, String userName, String string);

	void sendManagerCredentialsEmail(String companyName,String managerName,String email, String password);

}
