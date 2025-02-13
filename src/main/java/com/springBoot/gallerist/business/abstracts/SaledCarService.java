package com.springBoot.gallerist.business.abstracts;

import com.springBoot.gallerist.entities.dtos.DTOSaledCar;
import com.springBoot.gallerist.entities.dtos.IU.DTOSaledCarIU;

public interface SaledCarService {
	
	DTOSaledCar buyCar(DTOSaledCarIU dtoSaledCarIU);

}
