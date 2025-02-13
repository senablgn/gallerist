package com.springBoot.gallerist.entities.dtos.IU;

import java.math.BigDecimal;

import com.springBoot.gallerist.entities.enums.CurrencyType;

import io.micrometer.common.lang.NonNull;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class DTOAccountIU {
	@NotBlank
	private String accountNo;
	@NotBlank
	private String iban;
	@NotNull
	private BigDecimal amount;
	@NotNull
	private CurrencyType currencyType;

}
