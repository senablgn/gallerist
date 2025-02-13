package com.springBoot.gallerist.business.abstracts;

import com.springBoot.gallerist.entities.dtos.DTOCustomer;
import com.springBoot.gallerist.entities.dtos.IU.DTOCustomerIU;

public interface CustomerService {
	
	DTOCustomer save(DTOCustomerIU dtoCustomerIU);

}
