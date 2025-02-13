package com.springBoot.gallerist.api.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springBoot.gallerist.api.abstracts.AuthController;
import com.springBoot.gallerist.business.abstracts.AuthService;
import com.springBoot.gallerist.entities.dtos.DTOUser;
import com.springBoot.gallerist.jwt.AuthRequest;
import com.springBoot.gallerist.jwt.AuthResponse;
import com.springBoot.gallerist.jwt.RefreshTokenRequest;

import core.utilities.results.DataResult;
import core.utilities.results.SuccessDataResult;
import jakarta.validation.Valid;

@RestController
public class AuthControllerImpl implements AuthController{
	
	@Autowired
	private AuthService authService;

	@Override
	@PostMapping("/register")
	public DataResult<DTOUser> register(@Valid @RequestBody AuthRequest authRequest) {
		return new SuccessDataResult<DTOUser>(authService.register(authRequest), "user registered");
	}

	@Override
	@PostMapping("/authenticate")
	public DataResult<AuthResponse> authenticate(@Valid @RequestBody AuthRequest authRequest) {
		return new SuccessDataResult<AuthResponse>(authService.authenticate(authRequest), "authenticated");
	}

	@Override
	@PostMapping("/refreshToken")
	public DataResult<AuthResponse> refreshToken(@Valid @RequestBody RefreshTokenRequest refreshToken) {
		// TODO Auto-generated method stub
		return new SuccessDataResult<AuthResponse>(authService.refreshToken(refreshToken), "tokens renewed");
	}

	
	
	
	
	
	
	
	
	
}
