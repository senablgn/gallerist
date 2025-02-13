package com.springBoot.gallerist.api.abstracts;

import com.springBoot.gallerist.entities.dtos.DTOCar;
import com.springBoot.gallerist.entities.dtos.IU.DTOCarIU;

import core.utilities.results.DataResult;

public interface CarController {
	DataResult<DTOCar>save(DTOCarIU dtocarIU);
}
