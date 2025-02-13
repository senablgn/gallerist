package com.springBoot.gallerist.core.exceptions;

public class BaseException extends RuntimeException{

	public BaseException(ErrorMesssage errorMesssage) {
		super(errorMesssage.prepareErrorMessage());
	}
	
	

}
