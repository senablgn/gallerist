package com.springBoot.gallerist.business.abstracts;

import com.springBoot.gallerist.entities.dtos.DTOAccount;
import com.springBoot.gallerist.entities.dtos.IU.DTOAccountIU;

public interface AccountService {
	
	DTOAccount saveAccount(DTOAccountIU dtoAccountIU);

}
