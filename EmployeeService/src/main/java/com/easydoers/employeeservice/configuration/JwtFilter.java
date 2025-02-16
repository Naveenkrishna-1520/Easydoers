package com.easydoers.employeeservice.configuration;

import java.io.IOException;
import java.time.Instant;
import java.util.Collections;
import java.util.List;
import static com.easydoers.employeeservice.constants.RoleConstants.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import com.easydoers.employeeservice.entity.Store;
import com.easydoers.employeeservice.entity.Users;
import com.easydoers.employeeservice.service.JWTTokenService;
import com.easydoers.employeeservice.service.StoreService;
import com.easydoers.employeeservice.service.UserService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtFilter extends OncePerRequestFilter {

	@Autowired
	private JWTTokenService jwtTokenService;
	@Autowired
	@Lazy
	private StoreService storeService;
	@Autowired
	private UserService userService;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		String token = null;
		String role = null;
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
			role = jwtTokenService.getRoleFromToken(token);
		}

		if (userName != null && SecurityContextHolder.getContext().getAuthentication() == null) {

			if (EMPLOYEE.equals(role)) {
				Store store = storeService.checkStore(userName);
				if (store != null && jwtTokenService.validateToken(token, store)) {
					setAuthentication(store, role, request);
				}
			} else if (MANAGER.equals(role) || OWNER.equals(role) || ADMIN.equals(role)) {
				Users user = userService.findByUserName(userName);
				if (user != null && jwtTokenService.validateToken(token, user)) {
					setAuthentication(user, role, request);
				}
			}
		}

		response.setHeader("Last-Activity", Instant.now().toString());
		filterChain.doFilter(request, response);
	}

	private void setAuthentication(Object principal, String role, HttpServletRequest request) {
		List<SimpleGrantedAuthority> authorities = Collections
				.singletonList(new SimpleGrantedAuthority("ROLE_" + role));
		UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(principal, null,
				authorities);
		authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
		SecurityContextHolder.getContext().setAuthentication(authToken);
	}
}
