package com.springBoot.gallerist.api.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springBoot.gallerist.api.abstracts.CurrencyRatesController;
import com.springBoot.gallerist.business.abstracts.CurrencyRatesService;
import com.springBoot.gallerist.entities.evds.CurrencyRatesResponse;

import core.utilities.results.DataResult;
import core.utilities.results.SuccessDataResult;
@RestController
@RequestMapping("/api")
public class CurrencyRatesControllerImpl implements CurrencyRatesController{
	
	private CurrencyRatesService currencyRatesService;
	
	
	@Autowired
	public CurrencyRatesControllerImpl(CurrencyRatesService currencyRatesService) {
		super();
		this.currencyRatesService = currencyRatesService;
	}



	@Override
	@GetMapping("/currency-rates")
	public DataResult<CurrencyRatesResponse> getCurrencyRates(@RequestParam("startDate") String startDate,
			@RequestParam("endDate") String endDate) {
		return new SuccessDataResult<CurrencyRatesResponse>
		(this.currencyRatesService.getCurrencyRates(startDate, endDate), "currency rates listed");
	}
	
	
	

}
