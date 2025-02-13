package com.springBoot.gallerist.entities.dtos;

import lombok.Data;
@Data
public class DTOGallerist extends DTOBase{

	private String firstName;

	private String lastName;

	private DTOAddress address;
}
