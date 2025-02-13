package com.springBoot.gallerist.api.abstracts;

import com.springBoot.gallerist.entities.dtos.DTOGalleristCar;
import com.springBoot.gallerist.entities.dtos.IU.DTOGalleristCarIU;

import core.utilities.results.DataResult;

public interface GalleristCarController {
	
	DataResult<DTOGalleristCar>save(DTOGalleristCarIU dtoGalleristCarIU);

}
