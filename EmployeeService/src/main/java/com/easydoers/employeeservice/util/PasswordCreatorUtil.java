package com.easydoers.employeeservice.util;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class PasswordCreatorUtil {

	public CharSequence createPassword(String email) {
		String usernamePart = email.split("@")[0]; // Extract the part before @
		String symbol = "@"; // You can change this to any symbol you prefer
		String randomNumbers = getRandomNumbers(4); // Generate 4 random numbers

		return usernamePart + symbol + randomNumbers;
	}

	private static String getRandomNumbers(int length) {
		Random random = new Random();
		StringBuilder randomNumbers = new StringBuilder();

		for (int i = 0; i < length; i++) {
			randomNumbers.append(random.nextInt(10)); // Append a random digit between 0-9
		}

		return randomNumbers.toString();
	}

}
