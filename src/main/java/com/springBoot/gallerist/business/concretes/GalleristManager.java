package com.springBoot.gallerist.business.concretes;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springBoot.gallerist.business.abstracts.GalleristService;
import com.springBoot.gallerist.core.exceptions.BaseException;
import com.springBoot.gallerist.core.exceptions.ErrorMesssage;
import com.springBoot.gallerist.core.exceptions.MessageType;
import com.springBoot.gallerist.dataAccess.AddressRepository;
import com.springBoot.gallerist.dataAccess.GalleristRepository;
import com.springBoot.gallerist.entities.concretes.Address;
import com.springBoot.gallerist.entities.concretes.Gallerist;
import com.springBoot.gallerist.entities.dtos.DTOAddress;
import com.springBoot.gallerist.entities.dtos.DTOGallerist;
import com.springBoot.gallerist.entities.dtos.IU.DTOGalleristIU;

@Service
public class GalleristManager implements GalleristService{
	
	private GalleristRepository galleristRepository;
	private AddressRepository addressRepository;
	@Autowired
	public GalleristManager(GalleristRepository galleristRepository,AddressRepository addressRepository) {
		super();
		this.galleristRepository = galleristRepository;
		this.addressRepository=addressRepository;
	}
	
	
	private Gallerist createGallerist(DTOGalleristIU dtoGalleristIU) {
		Gallerist gallerist=new Gallerist();
		gallerist.setCreateDate(new Date());
		BeanUtils.copyProperties(dtoGalleristIU, gallerist);
		Optional<Address> optAddress = this.addressRepository.findById(dtoGalleristIU.getAddressId());
		if(optAddress.isEmpty()){
			throw new BaseException(new ErrorMesssage(MessageType.NO_RECORD_EXIST, null));
		}
		gallerist.setAddress(optAddress.get());
		return gallerist;
		
	}
	
	
	@Override
	public DTOGallerist save(DTOGalleristIU dtoGalleristIU) {
		DTOGallerist dtoGallerist=new DTOGallerist();
		DTOAddress dtoAddress=new DTOAddress();
		Gallerist save = this.galleristRepository.save(createGallerist(dtoGalleristIU));
		BeanUtils.copyProperties(save, dtoGallerist);
		BeanUtils.copyProperties(save.getAddress(), dtoAddress);
		dtoGallerist.setAddress(dtoAddress);
		return dtoGallerist;
	}
	
	
	
	
	
	
	
	

}
