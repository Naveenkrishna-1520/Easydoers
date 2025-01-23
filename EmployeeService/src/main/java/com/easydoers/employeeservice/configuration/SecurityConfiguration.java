package com.easydoers.employeeservice.configuration;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;


@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
	
	@Autowired
	private UserDetailsService userDetailsService;	
	@Autowired
	private JwtFilter jwtFilter;
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
		
		return http
			    .csrf(csrf -> csrf.disable())
			    .authorizeHttpRequests(auth -> 
			        auth.requestMatchers("/v1/auth/login", "/v1/auth/refreshToken").permitAll()
			            .anyRequest().authenticated())
			    .formLogin(form -> 
			        form.loginPage("/login")
			            .defaultSuccessUrl("/dashboard", true)
			            .permitAll())
			    .logout(logout -> 
			        logout.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
			              .logoutSuccessUrl("/login")
			              .permitAll())
			    .httpBasic(Customizer.withDefaults())
			    .sessionManagement(session -> 
			        session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
			    .cors(cors -> 
			        cors.configurationSource(corsConfigurationSource()))
			    .headers(headers -> headers
			        .contentSecurityPolicy(csp -> csp
			            .policyDirectives("default-src 'self'; script-src 'self'; object-src 'none'; connect-src 'self'; img-src 'self'; style-src 'self';"))
			        .frameOptions(frameOptions -> frameOptions
			            .deny()) 
			        .referrerPolicy(referrer -> referrer
			            .policy(org.springframework.security.web.header.writers.ReferrerPolicyHeaderWriter.ReferrerPolicy.NO_REFERRER))
			        .httpStrictTransportSecurity(hsts -> hsts
			            .maxAgeInSeconds(31536000) 
			            .includeSubDomains(true))
			        .addHeaderWriter((request, response) -> 
			            response.setHeader("X-XSS-Protection", "1; mode=block"))			    )
			    .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class)
			    .build();


		
	}
	@Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(List.of("http://localhost:3000")); // Allow specific origins
        configuration.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "OPTIONS")); // Allow HTTP methods
        configuration.setAllowedHeaders(List.of("Authorization", "Content-Type")); // Allow specific headers
        configuration.setAllowCredentials(true); // Allow cookies

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration); // Apply to all endpoints
        return source;
	}
	@Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
	
	@Bean
	public AuthenticationProvider authenticationProvider() {
		
		DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
		daoAuthenticationProvider.setPasswordEncoder(new BCryptPasswordEncoder(12));
		daoAuthenticationProvider.setUserDetailsService(userDetailsService);
		return daoAuthenticationProvider;
		
	}

	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
		return authenticationConfiguration.getAuthenticationManager();
		
	}
	
	
}
