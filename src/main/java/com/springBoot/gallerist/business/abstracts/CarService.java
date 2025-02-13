package com.springBoot.gallerist.business.abstracts;

import com.springBoot.gallerist.entities.dtos.DTOCar;
import com.springBoot.gallerist.entities.dtos.IU.DTOCarIU;

public interface CarService {
	
	DTOCar save(DTOCarIU dtoCarIU);

}
