package com.springBoot.gallerist.api.abstracts;

import com.springBoot.gallerist.entities.dtos.DTOUser;
import com.springBoot.gallerist.jwt.AuthRequest;
import com.springBoot.gallerist.jwt.AuthResponse;
import com.springBoot.gallerist.jwt.RefreshTokenRequest;

import core.utilities.results.DataResult;

public interface AuthController {
	
	DataResult<DTOUser>register(AuthRequest authRequest);
	DataResult<AuthResponse>authenticate(AuthRequest authRequest);
	DataResult<AuthResponse>refreshToken(RefreshTokenRequest refreshToken);

}
