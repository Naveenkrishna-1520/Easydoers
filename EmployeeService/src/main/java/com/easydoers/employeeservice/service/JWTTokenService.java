package com.easydoers.employeeservice.service;

import com.easydoers.employeeservice.entity.Store;
import com.easydoers.employeeservice.entity.Users;

public interface JWTTokenService {

	String extractUserName(String token);

	String getRoleFromToken(String token);

	boolean validateToken(String token, Users user);

	boolean validateToken(String token, Store store);

	String generateToken(String userName, String role);

	String generateRefreshToken(String userName, String role);

	boolean validateRefreshToken(String refreshToken);

	String extractUserNameFromRefreshToken(String refreshToken);

	String getRoleFromRefershToken(String refreshToken);

}
