package com.easydoers.employeeservice.service.implementation;

import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import org.springframework.stereotype.Service;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Service
public class JWTTokenService {

	public String generateToken(String userName) {
		Map<String, Object> claims = new HashMap<>();

		return Jwts.builder().claims().add(claims).subject(userName).issuedAt(new Date(System.currentTimeMillis()))
				.expiration(new Date(System.currentTimeMillis() + 60 * 60 * 300)).and().signWith(getKey()).compact();
	}

	private Key getKey() {
		try {
			KeyGenerator keyGenerator = KeyGenerator.getInstance("HmacSHA256");
			SecretKey key = keyGenerator.generateKey();
			String secretKey = Base64.getEncoder().encodeToString(key.getEncoded());
			byte[] keyBytes = Decoders.BASE64.decode(secretKey);

			return Keys.hmacShaKeyFor(keyBytes);

		} catch (NoSuchAlgorithmException e) {

			e.getMessage();
		}
		return null;
	}

	public String extractUsername(String token) {
		// TODO Auto-generated method stub
		return null;
	}

}
