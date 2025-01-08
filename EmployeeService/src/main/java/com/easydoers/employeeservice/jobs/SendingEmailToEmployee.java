package com.easydoers.employeeservice.jobs;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class SendingEmailToEmployee implements Job {

	@Autowired
	private JavaMailSender mailSender;

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		sendEmail();
		// Get current date, time, and zone
		ZonedDateTime now = ZonedDateTime.now();

		// Format to include timezone
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE, yyyy-MM-dd HH:mm:ss z");
		String formattedTime = now.format(formatter);
		System.out.println("Daily email sent at " + formattedTime);
	}

	private void sendEmail() {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo("employee@example.com"); // Replace with recipient's email
		message.setSubject("Daily Report");
		message.setText("This is your daily email report sent automatically at 9 AM.");

		mailSender.send(message);
		System.out.println("Email successfully sent!");
	}
}
