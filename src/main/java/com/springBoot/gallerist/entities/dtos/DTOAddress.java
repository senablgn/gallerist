package com.springBoot.gallerist.entities.dtos;

import lombok.Data;

@Data
public class DTOAddress extends DTOBase {

	private String city;

	private String district;

	private String neighborhood;

	private String street;

}
