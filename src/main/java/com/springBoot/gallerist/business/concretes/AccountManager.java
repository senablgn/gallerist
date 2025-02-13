package com.springBoot.gallerist.business.concretes;

import java.util.Date;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springBoot.gallerist.business.abstracts.AccountService;
import com.springBoot.gallerist.dataAccess.AccountRepository;
import com.springBoot.gallerist.entities.concretes.Account;
import com.springBoot.gallerist.entities.dtos.DTOAccount;
import com.springBoot.gallerist.entities.dtos.IU.DTOAccountIU;
import com.springBoot.gallerist.entities.dtos.IU.DTOAddressIU;

@Service
public class AccountManager implements AccountService{
	
	private AccountRepository accountRepository;
	@Autowired
	public AccountManager(AccountRepository accountRepository) {
		super();
		this.accountRepository = accountRepository;
	}
	
	private Account generateAccount(DTOAccountIU dtoAccountIU) {
		Account account=new Account();
		account.setCreateDate(new Date());
		BeanUtils.copyProperties(dtoAccountIU, account);
		return account;
	}
	
	
	@Override
	public DTOAccount saveAccount(DTOAccountIU dtoAccountIU) {
		DTOAccount dtoAccount=new DTOAccount();
		Account save = this.accountRepository.save(generateAccount(dtoAccountIU));
		BeanUtils.copyProperties(save, dtoAccount);
		return dtoAccount;
	}
	
	
	
	

}
