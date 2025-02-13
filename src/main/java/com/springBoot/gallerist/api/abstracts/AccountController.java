package com.springBoot.gallerist.api.abstracts;

import com.springBoot.gallerist.entities.dtos.DTOAccount;
import com.springBoot.gallerist.entities.dtos.IU.DTOAccountIU;

import core.utilities.results.DataResult;

public interface AccountController {
	
	DataResult<DTOAccount>saveAccount(DTOAccountIU dtoAccountIU);

}
