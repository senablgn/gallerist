package com.springBoot.gallerist.core.handler;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.springBoot.gallerist.core.exceptions.BaseException;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(value = BaseException.class)
	public ResponseEntity<ApiError<?>> handleBaseException(BaseException exception,WebRequest request) {
		return  ResponseEntity.badRequest().body(createApiError(exception.getMessage(), request));
	}
	
	@ExceptionHandler(value = {MethodArgumentNotValidException.class})
	public ResponseEntity<ApiError<Map<String, List<String>>>>handleMethodNotValidException(MethodArgumentNotValidException ex,WebRequest request){
		Map<String, List<String>> map=new HashMap<String, List<String>>();
		for(ObjectError objectError:ex.getBindingResult().getAllErrors()) {
			String fieldName=((FieldError)objectError).getField();
			if(map.containsKey(fieldName)) {
				map.put(fieldName, addValue(map.get(fieldName), objectError.getDefaultMessage()));
			}else {
				map.put(fieldName, addValue(new ArrayList<>(), objectError.getDefaultMessage()));
			}
			
		}
		
		return ResponseEntity.badRequest().body(createApiError(map, request));
	}
	
	
	
	private List<String> addValue(List<String> list,String newValue){
		list.add(newValue);
		return list;
	}
	
	
	
	public String getHost() {
		try {
			return InetAddress.getLocalHost().getHostAddress()+" : "+InetAddress.getLocalHost().getHostName();
		} catch (UnknownHostException e) {
			
			return "Host could not found";
		}
	}
	
	
	public <E> ApiError<E> createApiError(E message,WebRequest request){
		Exception exception=new Exception<E>();
		exception.setMessage(message);
		exception.setCreateTime(new Date());
		exception.setHostName(getHost());
		exception.setPath(request.getDescription(false).substring(4));
		
		ApiError<E> apiError=new ApiError<E>(HttpStatus.BAD_REQUEST.value(), exception);
		return apiError;
	}
	
	
	
}
