package com.springBoot.gallerist.api.abstracts;

import com.springBoot.gallerist.entities.dtos.DTOSaledCar;
import com.springBoot.gallerist.entities.dtos.IU.DTOSaledCarIU;

import core.utilities.results.DataResult;

public interface SaledCarController {
	
	DataResult<DTOSaledCar>buyCar(DTOSaledCarIU dtoSaledCarIU);

}
