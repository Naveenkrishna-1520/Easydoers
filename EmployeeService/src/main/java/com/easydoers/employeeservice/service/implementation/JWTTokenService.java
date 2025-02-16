package com.easydoers.employeeservice.service.implementation;


import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import javax.crypto.SecretKey;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import com.easydoers.employeeservice.entity.Store;
import com.easydoers.employeeservice.entity.Users;
import com.easydoers.employeeservice.exception.SignatureExceptionFound;
import com.easydoers.employeeservice.exception.TokenInvalidException;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SignatureException;

@Service
public class JWTTokenService {
	
	private final String secretKey;
    private final String refreshSecretKey;

    public JWTTokenService(Environment env) {
        this.secretKey = env.getProperty("jwt.secret.key");
        this.refreshSecretKey = env.getProperty("jwt.refresh.secret.key");
    }

	public String generateToken(String userName, String role) {
		Map<String, Object> claims = new HashMap<>();
		claims.put("ROLE",role);

		return Jwts.builder().claims().add(claims).subject(userName).issuedAt(new Date(System.currentTimeMillis()))
				.expiration(new Date(System.currentTimeMillis() + 1000 * 60 * 30)).and().signWith(getKey()).compact();
	}
	
	public String generateRefreshToken(String userName, String role) {
		Map<String, Object> claims = new HashMap<>();
		claims.put("ROLE",role);
		return Jwts.builder().claims().add(claims).subject(userName).issuedAt(new Date(System.currentTimeMillis()))
				.expiration(new Date(System.currentTimeMillis() + 7 * 24 * 60 * 60 * 1000)).and().signWith(getRefreshKey()).compact();
	}

	private SecretKey getRefreshKey() {
		byte[] keyBytes = Decoders.BASE64.decode(refreshSecretKey);
        return Keys.hmacShaKeyFor(keyBytes);
	}

	private SecretKey getKey() {
        byte[] keyBytes = Decoders.BASE64.decode(secretKey);
        return Keys.hmacShaKeyFor(keyBytes);
    }

	public String extractUserName(String token) {
        // extract the username from jwt token
        return extractClaim(token, Claims::getSubject);
    }

    private <T> T extractClaim(String token, Function<Claims, T> claimResolver) {
        final Claims claims = extractAllClaims(token);
        return claimResolver.apply(claims);
    }

    private Claims extractAllClaims(String token){
    	try {
    		return Jwts.parser()
                    .verifyWith(getKey())
                    .build()
                    .parseSignedClaims(token)
                    .getPayload();
    	} catch (ExpiredJwtException e) {
            throw new TokenInvalidException("Token has expired");	
    	} catch (MalformedJwtException e) {
            throw new TokenInvalidException("Invalid JWT structure");
        } catch (SignatureException e) {
        	System.out.println("extract all claims method");
            throw new SignatureExceptionFound("Invalid JWT signature");
        } catch (Exception e) {
            throw new TokenInvalidException("Token is invalid");
		}
        
    }

    public boolean validateToken(String token, Store store) {
        final String userName = extractUserName(token);
        return (userName.equalsIgnoreCase(store.getDealerStoreId()) && !isTokenExpired(token));
    }

    private boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    private Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

	public boolean validateRefreshToken(String refreshToken) {
		
		try {
    		 Jwts.parser()
                    .verifyWith(getRefreshKey())
                    .build()
                    .parseSignedClaims(refreshToken)
                    .getPayload();
    		 return true;
    	} catch (ExpiredJwtException e) {
            throw new TokenInvalidException("Token has expired");	
    	} catch (MalformedJwtException e) {
            throw new TokenInvalidException("Invalid JWT structure");
        } catch (SignatureException e) {
            throw new SignatureExceptionFound("Invalid JWT signature");
        } catch (Exception e) {
            throw new TokenInvalidException("Token is invalid");
		}
	}

	public String extractUserNameFromRefreshToken(String refreshToken) {
		
		return Jwts.parser()
                .verifyWith(getRefreshKey())
                .build()
                .parseSignedClaims(refreshToken)
                .getPayload().getSubject();	
	}
	
	public String getRoleFromToken(String token) {
		   
        return (String) Jwts.parser()
                .verifyWith(getKey())
                .build()
                .parseSignedClaims(token)
                .getPayload()
                .get("ROLE");
    
}
	
	public String getRoleFromRefershToken(String refreshToken) {
	   
	        return (String) Jwts.parser()
	                .verifyWith(getRefreshKey())
	                .build()
	                .parseSignedClaims(refreshToken)
	                .getPayload()
	                .get("ROLE");
	    
	}

	public boolean validateToken(String token, Users user) {
		String username = extractUserName(token);
        return (username != null && !isTokenExpired(token));
    }

}
