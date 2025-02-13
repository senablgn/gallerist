package com.springBoot.gallerist.business.abstracts;

import com.springBoot.gallerist.entities.dtos.DTOAddress;
import com.springBoot.gallerist.entities.dtos.IU.DTOAddressIU;

public interface AddressService {
	
	DTOAddress saveAddress(DTOAddressIU dtoAddressIU);

}
