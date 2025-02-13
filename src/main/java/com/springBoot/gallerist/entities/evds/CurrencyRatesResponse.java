package com.springBoot.gallerist.entities.evds;

import java.util.List;

import lombok.Data;
@Data
public class CurrencyRatesResponse {
	
	
	private int totalCount;
	
	private List<CurrencyRatesItems>items;
	
	
	
	
//	{
//	    "totalCount": 1,
//	    "items": [
//	        {
//	            "Tarih": "07-02-2025",
//	            "TP_DK_USD_A": "35.8332",
//	            "UNIXTIME": {
//	                "$numberLong": "1738875600"
//	            }
//	        }
//	    ]
//	}
	
	
	

}
