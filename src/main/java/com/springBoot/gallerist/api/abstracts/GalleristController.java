package com.springBoot.gallerist.api.abstracts;

import com.springBoot.gallerist.entities.dtos.DTOGallerist;
import com.springBoot.gallerist.entities.dtos.IU.DTOGalleristIU;

import core.utilities.results.DataResult;

public interface GalleristController {
	DataResult<DTOGallerist>save(DTOGalleristIU dtoGalleristIU);

}
