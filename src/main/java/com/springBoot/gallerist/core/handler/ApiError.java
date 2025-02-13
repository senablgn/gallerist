package com.springBoot.gallerist.core.handler;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiError <E>{
	
	private int status;
	private Exception<E> exception;

}
