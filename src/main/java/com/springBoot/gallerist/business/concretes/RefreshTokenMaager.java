package com.springBoot.gallerist.business.concretes;

import java.util.Date;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springBoot.gallerist.business.abstracts.RefreshTokenService;
import com.springBoot.gallerist.core.exceptions.BaseException;
import com.springBoot.gallerist.core.exceptions.ErrorMesssage;
import com.springBoot.gallerist.core.exceptions.MessageType;
import com.springBoot.gallerist.dataAccess.RefreshTokenRepository;
import com.springBoot.gallerist.entities.concretes.RefreshToken;
import com.springBoot.gallerist.entities.concretes.User;
import com.springBoot.gallerist.jwt.JWTService;

@Service
public class RefreshTokenMaager implements RefreshTokenService{
	
	private RefreshTokenRepository refreshTokenRepository;
	
	

	@Autowired
	public RefreshTokenMaager(RefreshTokenRepository refreshTokenRepository) {
		super();
		this.refreshTokenRepository = refreshTokenRepository;
	}

	@Override
	public RefreshToken createRefresfToken(User user) {
		RefreshToken refreshToken=new RefreshToken();
		refreshToken.setCreateDate(new Date());
		refreshToken.setExpiredDate(new Date(System.currentTimeMillis()+1000*60*60*4));
		refreshToken.setRefreshToken(UUID.randomUUID().toString());
		refreshToken.setUser(user);
		return refreshToken;
	}

	@Override
	public RefreshToken saveRefreshToken(RefreshToken refreshToken) {
		return this.refreshTokenRepository.save(refreshToken);
	}
	
	
	
	
	

	@Override
	public RefreshToken findByRefreshToken(String RefreshToken) {
		Optional<RefreshToken> optionalRefresh = refreshTokenRepository.findByRefreshToken(RefreshToken);
		if(optionalRefresh.isEmpty()) {
			throw new BaseException(new ErrorMesssage(MessageType.REFRESH_TOKEN_NOT_FOUND, null));
		}
		

		return optionalRefresh.get();
	}
	
	
	
	
	
	
	
	
	

}
