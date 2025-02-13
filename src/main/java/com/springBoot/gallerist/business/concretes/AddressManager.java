package com.springBoot.gallerist.business.concretes;

import java.util.Date;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springBoot.gallerist.business.abstracts.AddressService;
import com.springBoot.gallerist.dataAccess.AddressRepository;
import com.springBoot.gallerist.entities.concretes.Address;
import com.springBoot.gallerist.entities.dtos.DTOAddress;
import com.springBoot.gallerist.entities.dtos.IU.DTOAddressIU;

@Service
public class AddressManager implements AddressService{
	
	private AddressRepository addressRepository;
	@Autowired
	public AddressManager(AddressRepository addressRepository) {
		super();
		this.addressRepository = addressRepository;
	}
	
	
	private Address generateAddress(DTOAddressIU dtoAddressIU) {
		Address address=new Address();
		address.setCreateDate(new Date());
		BeanUtils.copyProperties(dtoAddressIU, address);
		return address;
	}
	
	
	@Override
	public DTOAddress saveAddress(DTOAddressIU dtoAddressIU) {
		DTOAddress dtoAddress=new DTOAddress();
		Address savedAddress = addressRepository.save(generateAddress(dtoAddressIU));
		BeanUtils.copyProperties(savedAddress, dtoAddress);
		return dtoAddress;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
