package com.springBoot.gallerist.entities.dtos;

import lombok.Data;

@Data
public class DTOSaledCar  extends DTOBase{
	
	DTOGallerist gallerist;
	DTOCar car;
	DTOCustomer customer;
}
