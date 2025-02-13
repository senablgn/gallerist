package com.springBoot.gallerist.api.abstracts;

import com.springBoot.gallerist.entities.dtos.DTOAddress;
import com.springBoot.gallerist.entities.dtos.IU.DTOAddressIU;

import core.utilities.results.DataResult;

public interface AddressController {
	
	 DataResult<DTOAddress>saveAddress(DTOAddressIU dtoAddressIU);

}
