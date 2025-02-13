package com.springBoot.gallerist.business.concretes;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.springBoot.gallerist.business.abstracts.AuthService;
import com.springBoot.gallerist.business.abstracts.RefreshTokenService;
import com.springBoot.gallerist.core.exceptions.BaseException;
import com.springBoot.gallerist.core.exceptions.ErrorMesssage;
import com.springBoot.gallerist.core.exceptions.MessageType;
import com.springBoot.gallerist.dataAccess.UserRepository;
import com.springBoot.gallerist.entities.concretes.RefreshToken;
import com.springBoot.gallerist.entities.concretes.User;
import com.springBoot.gallerist.entities.dtos.DTOUser;
import com.springBoot.gallerist.jwt.AuthRequest;
import com.springBoot.gallerist.jwt.AuthResponse;
import com.springBoot.gallerist.jwt.JWTService;
import com.springBoot.gallerist.jwt.RefreshTokenRequest;

@Service
public class AuthManager implements AuthService{
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	@Autowired
	private RefreshTokenService refreshTokenService;
	@Autowired
	private JWTService jwtService;
	@Autowired
	private AuthenticationProvider authenticationProvider;
	
	
	private User createUser(AuthRequest request) {
		User user=new User();
		user.setCreateDate(new Date());
		user.setUsername(request.getUsername());
		user.setPassword(bCryptPasswordEncoder.encode(request.getPassword()));
		return user;
		
	}
	
	
	

	@Override
	public DTOUser register(AuthRequest authRequest) {
		DTOUser dtoUser=new DTOUser();
		User savedUser = userRepository.save(createUser(authRequest));
		BeanUtils.copyProperties(savedUser, dtoUser);
		return dtoUser;
	}




	@Override
	public AuthResponse authenticate(AuthRequest authRequest) {
		try {
			UsernamePasswordAuthenticationToken authenticationToken=
				new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword());
		authenticationProvider.authenticate(authenticationToken);
		Optional<User> optionalUser = userRepository.findByUsername(authRequest.getUsername());
		String accessToken = jwtService.generateToken(optionalUser.get());
		;
		RefreshToken saveRefreshToken = 
				refreshTokenService.saveRefreshToken(refreshTokenService.createRefresfToken(optionalUser.get()));
		
		return new AuthResponse(accessToken, saveRefreshToken.getRefreshToken());
		
		} catch (Exception e) {
			throw new BaseException(new ErrorMesssage(MessageType.USERNAME_PASSWORD_INVALID, e.getMessage()));
		}
		
		
		
		
		
		
		
		
		
		
	}


	private boolean isTokenExpired(Date date) {
		return new Date().before(date);
	}

	@Override
	public AuthResponse refreshToken(RefreshTokenRequest refreshTokenRequest) {
		RefreshToken refreshToken = refreshTokenService.findByRefreshToken(refreshTokenRequest.getRefreshToken());
		
		if(!isTokenExpired(refreshToken.getExpiredDate())) {
			throw new BaseException(new ErrorMesssage(MessageType.REFRESH_TOKEN_NOT_FOUND, null));
		}
		
		String accessToken = jwtService.generateToken(refreshToken.getUser());
		RefreshToken newRefreshToken = refreshTokenService.createRefresfToken(refreshToken.getUser());
		RefreshToken saveRefreshToken = refreshTokenService.saveRefreshToken(newRefreshToken);
		
		return new AuthResponse(accessToken, saveRefreshToken.getRefreshToken());
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
