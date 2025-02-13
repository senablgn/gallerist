package com.springBoot.gallerist.business.abstracts;

import com.springBoot.gallerist.entities.dtos.DTOUser;
import com.springBoot.gallerist.jwt.AuthRequest;
import com.springBoot.gallerist.jwt.AuthResponse;
import com.springBoot.gallerist.jwt.RefreshTokenRequest;

public interface AuthService {
	
	DTOUser register(AuthRequest authRequest);
	AuthResponse authenticate(AuthRequest authRequest);
	AuthResponse refreshToken(RefreshTokenRequest refreshTokenRequest);

}
