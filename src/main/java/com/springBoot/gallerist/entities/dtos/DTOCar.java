package com.springBoot.gallerist.entities.dtos;

import java.math.BigDecimal;

import com.springBoot.gallerist.entities.enums.CarStatusType;
import com.springBoot.gallerist.entities.enums.CurrencyType;

import lombok.Data;
@Data
public class DTOCar extends DTOBase{
	
	private String plaka;

	private String brand;

	private String model;
	
	private Integer productionYear;

	private BigDecimal price;

	private CurrencyType currencyType;

	private BigDecimal damagePrice;

	private CarStatusType carStatusType;
}
