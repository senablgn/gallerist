package com.springBoot.gallerist.business.concretes;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.springBoot.gallerist.business.abstracts.CurrencyRatesService;
import com.springBoot.gallerist.core.exceptions.BaseException;
import com.springBoot.gallerist.core.exceptions.ErrorMesssage;
import com.springBoot.gallerist.core.exceptions.MessageType;
import com.springBoot.gallerist.entities.evds.CurrencyRatesResponse;

@Service
public class CurrencyRatesManager implements CurrencyRatesService {

	@Override
	public CurrencyRatesResponse getCurrencyRates(String startDate, String endDate) {
		String rootUrl = "https://evds2.tcmb.gov.tr/service/evds/";
		String series = "TP.DK.USD.A";
		String type = "json";
//https://evds2.tcmb.gov.tr/service/evds/series=TP.DK.USD.A&startDate=07-02-2025&endDate=07-02-2025&type=json

		String endPoint = rootUrl + "series=" + series + "&startDate=" + startDate + "&endDate=" + endDate + "&type="
				+ type;
		HttpHeaders headers = new HttpHeaders();
		headers.set("Key", "uvJ3leaEwE");
		HttpEntity<?> httpEntity = new HttpEntity<>(headers);

		try {
			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<CurrencyRatesResponse> response =
					restTemplate.exchange(endPoint, HttpMethod.GET, httpEntity,
					new ParameterizedTypeReference<CurrencyRatesResponse>() {
					});
			if (response.getStatusCode().is2xxSuccessful()) {
				return response.getBody();
			}
		} catch (Exception e) {
			throw new BaseException(new ErrorMesssage(MessageType.CURRENCY_RATES_IS_ACCOURED, e.getMessage()));
		}

		return null;
	}

}
