package com.springBoot.gallerist.entities.dtos.IU;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class DTOSaledCarIU {
	@NotNull
	Long galleristId;
	@NotNull
	Long carId;
	@NotNull
	Long customerId;

}
