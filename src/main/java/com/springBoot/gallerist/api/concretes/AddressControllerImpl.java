package com.springBoot.gallerist.api.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springBoot.gallerist.api.abstracts.AddressController;
import com.springBoot.gallerist.business.abstracts.AddressService;
import com.springBoot.gallerist.entities.dtos.DTOAddress;
import com.springBoot.gallerist.entities.dtos.IU.DTOAddressIU;

import core.utilities.results.DataResult;
import core.utilities.results.SuccessDataResult;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/address")
public class AddressControllerImpl implements AddressController{
	
	private AddressService addressService;
	@Autowired
	public AddressControllerImpl(AddressService addressService) {
		super();
		this.addressService = addressService;
	}
	@Override
	@PostMapping("/saveAddress")
	public DataResult<DTOAddress> saveAddress(@Valid @RequestBody DTOAddressIU dtoAddressIU) {
		return new SuccessDataResult<DTOAddress>(this.addressService.saveAddress(dtoAddressIU), "address saved") ;
	}
	
	
	
	
	

}
