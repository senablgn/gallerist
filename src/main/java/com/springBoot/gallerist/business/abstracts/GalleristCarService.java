package com.springBoot.gallerist.business.abstracts;

import com.springBoot.gallerist.entities.dtos.DTOGalleristCar;
import com.springBoot.gallerist.entities.dtos.IU.DTOGalleristCarIU;

public interface GalleristCarService {
	
	DTOGalleristCar save(DTOGalleristCarIU dtoGalleristCarIU);

}
