package com.springBoot.gallerist.api.abstracts;

import com.springBoot.gallerist.entities.evds.CurrencyRatesResponse;

import core.utilities.results.DataResult;

public interface CurrencyRatesController {
	
	DataResult<CurrencyRatesResponse>getCurrencyRates(String startDate,String endDate);

}
