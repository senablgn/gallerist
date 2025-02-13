package com.springBoot.gallerist.api.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springBoot.gallerist.api.abstracts.AccountController;
import com.springBoot.gallerist.business.abstracts.AccountService;
import com.springBoot.gallerist.entities.dtos.DTOAccount;
import com.springBoot.gallerist.entities.dtos.IU.DTOAccountIU;

import core.utilities.results.DataResult;
import core.utilities.results.SuccessDataResult;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/account")
public class AccountControllerImpl implements AccountController{
	
	private AccountService accountService;
	@Autowired
	public AccountControllerImpl(AccountService accountService) {
		super();
		this.accountService = accountService;
	}
	@Override
	@PostMapping("/save")
	public DataResult<DTOAccount> saveAccount(@Valid @RequestBody DTOAccountIU dtoAccountIU) {
		// TODO Auto-generated method stub
		return new SuccessDataResult<DTOAccount>(this.accountService.saveAccount(dtoAccountIU), "account saved");
	}
	
	
	
	
	
	
	

}
