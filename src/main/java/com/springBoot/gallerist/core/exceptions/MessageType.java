package com.springBoot.gallerist.core.exceptions;

import lombok.Getter;

@Getter
public enum MessageType {

	NO_RECORD_EXIST("1001", "record not found"),
	EXPIRED_TOKEN("1002","token is expired"),
	USERNAME_NOT_FOUND("1003","username not found"),
	USERNAME_PASSWORD_INVALID("1004","username or password invalid"),
	REFRESH_TOKEN_NOT_FOUND("1005","refresh token not found"),
	REFRESH_TOKEN_EXPIRED("1005","refresh token is expired"),
	CURRENCY_RATES_IS_ACCOURED("1006","Could not get exchange rate"),
	CUSTOMER_AMOUNT_NOT_ENOUGH("1007","Customer amount is not enough"),
	CAR_STATUS_IS_SALED("1008","Car is already saled"),
	GENERAL_EXCEPTION("9999", "general error has accoured");

	private String code;
	private String message;

	private MessageType(String code, String message) {
		this.code = code;
		this.message = message;
	}

}
