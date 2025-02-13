package com.springBoot.gallerist.entities.dtos;

import java.math.BigDecimal;

import com.springBoot.gallerist.entities.enums.CurrencyType;

import lombok.Data;

@Data
public class DTOAccount extends DTOBase{
	

	private String accountNo;

	private String iban;

	private BigDecimal amount;

	private CurrencyType currencyType;

}
