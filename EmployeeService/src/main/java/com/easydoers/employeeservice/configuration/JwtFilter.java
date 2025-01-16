package com.easydoers.employeeservice.configuration;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import com.easydoers.employeeservice.entity.Store;
import com.easydoers.employeeservice.service.StoreService;
import com.easydoers.employeeservice.service.implementation.JWTTokenService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtFilter extends OncePerRequestFilter{
	
	@Autowired
	private JWTTokenService jwtTokenService;
	@Autowired
	private StoreService storeService;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		String token = null;
		String userName = null;
        if (request.getCookies() != null) {
            for (Cookie cookie : request.getCookies()) {
                if ("accessToken".equals(cookie.getName())) {
                    token = cookie.getValue();
                    break;
                }
            }
        }
        if (token != null && !token.isEmpty()) {
            userName = jwtTokenService.extractUserName(token);
        }
		
		if(userName != null && SecurityContextHolder.getContext().getAuthentication()==null) {
			
			Store store = storeService.checkStore(userName);
			if(jwtTokenService.validateToken(token, store)) {
				UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                        store, null, null); // Store doesn't have authorities; pass `null`
                authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authToken);
			}
		}
		filterChain.doFilter(request, response);
	}

}
