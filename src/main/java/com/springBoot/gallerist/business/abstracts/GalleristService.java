package com.springBoot.gallerist.business.abstracts;

import com.springBoot.gallerist.entities.dtos.DTOGallerist;
import com.springBoot.gallerist.entities.dtos.IU.DTOGalleristIU;

public interface GalleristService {

	DTOGallerist save(DTOGalleristIU dtoGalleristIU);
}
