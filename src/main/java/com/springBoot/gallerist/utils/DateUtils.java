package com.springBoot.gallerist.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
	
	public static String getCurrencyDate(Date date) {
		
		SimpleDateFormat simpleDateFormat=new SimpleDateFormat("dd-MM-yyyy");
		return simpleDateFormat.format(date);
		
	}

}
