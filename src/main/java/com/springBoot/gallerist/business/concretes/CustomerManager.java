package com.springBoot.gallerist.business.concretes;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springBoot.gallerist.business.abstracts.CustomerService;
import com.springBoot.gallerist.core.exceptions.BaseException;
import com.springBoot.gallerist.core.exceptions.ErrorMesssage;
import com.springBoot.gallerist.core.exceptions.MessageType;
import com.springBoot.gallerist.dataAccess.AccountRepository;
import com.springBoot.gallerist.dataAccess.AddressRepository;
import com.springBoot.gallerist.dataAccess.CustomerRepository;
import com.springBoot.gallerist.entities.concretes.Account;
import com.springBoot.gallerist.entities.concretes.Address;
import com.springBoot.gallerist.entities.concretes.Customer;
import com.springBoot.gallerist.entities.dtos.DTOAccount;
import com.springBoot.gallerist.entities.dtos.DTOAddress;
import com.springBoot.gallerist.entities.dtos.DTOCustomer;
import com.springBoot.gallerist.entities.dtos.IU.DTOCustomerIU;

@Service
public class CustomerManager implements CustomerService{
	
	private CustomerRepository customerRepository;
	@Autowired
	private AccountRepository accountRepository;
	@Autowired
	AddressRepository addressRepository;
	
	@Autowired
	public CustomerManager(CustomerRepository customerRepository) {
		super();
		this.customerRepository = customerRepository;
	}
	
	
	private Customer generateCustomer(DTOCustomerIU dtoCustomerIU) {
		Customer customer=new Customer();
		customer.setCreateDate(new Date());
		BeanUtils.copyProperties(dtoCustomerIU, customer);
		Optional<Account> optAccount = accountRepository.findById(dtoCustomerIU.getAccountId());
		if(optAccount.isEmpty()) {
			throw new BaseException(new ErrorMesssage(MessageType.NO_RECORD_EXIST, null));
		}
		Optional<Address> optAddress = addressRepository.findById(dtoCustomerIU.getAddressId());
		if(optAddress.isEmpty()) {
			throw new BaseException(new ErrorMesssage(MessageType.NO_RECORD_EXIST, null));
		}
		customer.setAccount(optAccount.get());
		customer.setAddress(optAddress.get());
		
		
		return customer;
	}
	
	
	
	
	
	
	@Override
	public DTOCustomer save(DTOCustomerIU dtoCustomerIU) {
		DTOCustomer dtoCustomer=new DTOCustomer();
		DTOAccount dtoAccount=new DTOAccount();
		DTOAddress dtoAddress=new DTOAddress();
		
		Customer save = this.customerRepository.save(generateCustomer(dtoCustomerIU));
		BeanUtils.copyProperties(save.getAddress(), dtoAddress);
		BeanUtils.copyProperties(save.getAccount(), dtoAccount);
		BeanUtils.copyProperties(save, dtoCustomer);
		
		dtoCustomer.setAccount(dtoAccount);
		dtoCustomer.setAddress(dtoAddress);
		
		return dtoCustomer;
	}
	
	
	
	
	

}
