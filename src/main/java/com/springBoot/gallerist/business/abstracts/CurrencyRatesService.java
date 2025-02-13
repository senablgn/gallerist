package com.springBoot.gallerist.business.abstracts;

import com.springBoot.gallerist.entities.evds.CurrencyRatesResponse;

public interface CurrencyRatesService {
	
	CurrencyRatesResponse getCurrencyRates(String startDate,String endDate);

}
