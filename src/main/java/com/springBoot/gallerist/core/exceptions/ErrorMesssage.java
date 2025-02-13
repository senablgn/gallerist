package com.springBoot.gallerist.core.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorMesssage {
	
	private MessageType messageType;
	private String ofStatic;
	
	public String prepareErrorMessage() {
		StringBuilder builder=new StringBuilder();
		builder.append(messageType.getCode()+" : "+messageType.getMessage());
		if(ofStatic!=null) {
			builder.append(" - " +ofStatic);
		}
		return builder.toString();
	}

}
