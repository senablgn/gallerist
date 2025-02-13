package com.springBoot.gallerist.api.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springBoot.gallerist.api.abstracts.CustomerController;
import com.springBoot.gallerist.business.abstracts.CustomerService;
import com.springBoot.gallerist.entities.dtos.DTOCustomer;
import com.springBoot.gallerist.entities.dtos.IU.DTOCustomerIU;

import core.utilities.results.DataResult;
import core.utilities.results.SuccessDataResult;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/customer")
public class CustomerControllerImpl implements CustomerController{
	
	private CustomerService customerService;
	@Autowired
	public CustomerControllerImpl(CustomerService customerService) {
		super();
		this.customerService = customerService;
	}
	@Override
	@PostMapping("/save")
	public DataResult<DTOCustomer> save(@Valid @RequestBody DTOCustomerIU dtoCustomerIU) {		
		return new SuccessDataResult<DTOCustomer>(this.customerService.save(dtoCustomerIU), "customer saved");
	}
	
	
	
	
	
	

}
