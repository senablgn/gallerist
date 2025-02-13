package com.springBoot.gallerist.entities.dtos.IU;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
@Data
public class DTOAddressIU {

	@NotBlank
	private String city;

	@NotBlank
	private String district;

	@NotBlank
	private String neighborhood;

	@NotBlank
	private String street;

}
