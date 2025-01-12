package com.easydoers.employeeservice.service.implementation;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import io.jsonwebtoken.Jwts;

@Service
public class JWTTokenService {

	public String generateToken(String userName) {
		Map<String, Object> claims = new HashMap<>();
		
		
		return Jwts.builder()
				.claims()
				.add(claims)
				.subject(userName)
				.issuedAt(new Date(System.currentTimeMillis()))
				.expiration(new Date(System.currentTimeMillis() +60*60*30))
				.and()
				.signWith(getKey())
				.compact();
	}

	private Key getKey() {
		// TODO Auto-generated method stub
		return null;
	}

}
