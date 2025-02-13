package com.springBoot.gallerist.api.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springBoot.gallerist.api.abstracts.SaledCarController;
import com.springBoot.gallerist.business.abstracts.SaledCarService;
import com.springBoot.gallerist.entities.dtos.DTOSaledCar;
import com.springBoot.gallerist.entities.dtos.IU.DTOSaledCarIU;

import core.utilities.results.DataResult;
import core.utilities.results.SuccessDataResult;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/saledCar")
public class SaledCarControllerImpl implements SaledCarController{
	
	private SaledCarService saledCarService;
	@Autowired
	public SaledCarControllerImpl(SaledCarService saledCarService) {
		super();
		this.saledCarService = saledCarService;
	}
	@Override
	@PostMapping("/buy")
	public DataResult<DTOSaledCar> buyCar(@Valid @RequestBody DTOSaledCarIU dtoSaledCarIU) {
		return new SuccessDataResult<DTOSaledCar>(this.saledCarService.buyCar(dtoSaledCarIU), "buy saled");
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
