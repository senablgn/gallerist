package com.springBoot.gallerist.business.abstracts;

import com.springBoot.gallerist.entities.concretes.RefreshToken;
import com.springBoot.gallerist.entities.concretes.User;

public interface RefreshTokenService {
	
	RefreshToken createRefresfToken(User user);
	RefreshToken saveRefreshToken(RefreshToken refreshToken);
	RefreshToken findByRefreshToken(String RefreshToken);

}
