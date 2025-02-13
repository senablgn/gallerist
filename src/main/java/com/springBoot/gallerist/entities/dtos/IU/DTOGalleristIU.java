package com.springBoot.gallerist.entities.dtos.IU;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class DTOGalleristIU {
	@NotBlank
	private String firstName;
	@NotBlank
	private String lastName;
	@NotNull
	private Long addressId;

}
