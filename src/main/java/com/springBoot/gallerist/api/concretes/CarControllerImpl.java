package com.springBoot.gallerist.api.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springBoot.gallerist.api.abstracts.CarController;
import com.springBoot.gallerist.business.abstracts.CarService;
import com.springBoot.gallerist.entities.dtos.DTOCar;
import com.springBoot.gallerist.entities.dtos.IU.DTOCarIU;
import com.springBoot.gallerist.entities.dtos.IU.DTOCustomerIU;

import core.utilities.results.DataResult;
import core.utilities.results.SuccessDataResult;
import jakarta.validation.Valid;
@RestController
@RequestMapping("/api/car")
public class CarControllerImpl implements CarController{
	
	private CarService carService;
	@Autowired
	public CarControllerImpl(CarService carService) {
		super();
		this.carService = carService;
	}
	@Override
	@PostMapping("/save")
	public DataResult<DTOCar> save(@Valid @RequestBody DTOCarIU dtoCarIU) {
		
		return new SuccessDataResult<DTOCar>(this.carService.save(dtoCarIU), "car saved");
	}
	
	
	
	

}
