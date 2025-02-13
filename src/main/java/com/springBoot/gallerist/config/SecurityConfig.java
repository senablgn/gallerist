package com.springBoot.gallerist.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.springBoot.gallerist.jwt.JWTAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig   {
	
	public static final String REGISTER="/register";
	public static final String AUTHENTICATE="/authenticate";
	public static final String REFRESH_TOKEN="/refreshToken";
	@Autowired
	private AuthenticationProvider authenticationProvider;
	@Autowired
	private JWTAuthenticationFilter jwtAuthenticationFilter;
	
	@Autowired
	private AuthenticationEntryPoint authenticationEntryPoint;
	

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.csrf(csrf->csrf.disable())
		.authorizeHttpRequests(request->
		request.requestMatchers(REGISTER,AUTHENTICATE,REFRESH_TOKEN).permitAll()
		.anyRequest().authenticated())
		.exceptionHandling(exception->exception.authenticationEntryPoint(authenticationEntryPoint))
		.sessionManagement(session->session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
		.authenticationProvider(authenticationProvider)
		.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
	return httpSecurity.build();
	}
	

}
