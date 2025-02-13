package com.springBoot.gallerist.entities.dtos;

import lombok.Data;
@Data
public class DTOGalleristCar extends DTOBase{

	private DTOGallerist gallerist;

	private DTOCar car;

}
