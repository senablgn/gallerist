package com.springBoot.gallerist.entities.dtos.IU;

import java.math.BigDecimal;

import com.springBoot.gallerist.entities.enums.CarStatusType;
import com.springBoot.gallerist.entities.enums.CurrencyType;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
@Data
public class DTOCarIU {
	@NotNull
	private String plaka;
	@NotBlank
	private String brand;
	@NotBlank
	private String model;
	@NotNull
	private Integer productionYear;
	@NotNull
	private BigDecimal price;
	@NotNull
	private CurrencyType currencyType;
	@NotNull
	private BigDecimal damagePrice;
	@NotNull
	private CarStatusType carStatusType;

}
