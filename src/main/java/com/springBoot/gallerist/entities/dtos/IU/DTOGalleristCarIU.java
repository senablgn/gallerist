package com.springBoot.gallerist.entities.dtos.IU;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class DTOGalleristCarIU {
	@NotNull
	private Long galleristId;
	@NotNull
	private Long carId;

}
