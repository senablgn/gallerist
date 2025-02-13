package com.springBoot.gallerist.api.abstracts;

import com.springBoot.gallerist.entities.dtos.DTOCustomer;
import com.springBoot.gallerist.entities.dtos.IU.DTOCustomerIU;

import core.utilities.results.DataResult;

public interface CustomerController {
	
	DataResult<DTOCustomer> save(DTOCustomerIU dtoCustomerIU);

}
