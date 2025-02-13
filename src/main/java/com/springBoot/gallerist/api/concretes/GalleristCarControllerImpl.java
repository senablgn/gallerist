package com.springBoot.gallerist.api.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springBoot.gallerist.api.abstracts.GalleristCarController;
import com.springBoot.gallerist.business.abstracts.GalleristCarService;
import com.springBoot.gallerist.entities.dtos.DTOGalleristCar;
import com.springBoot.gallerist.entities.dtos.IU.DTOGalleristCarIU;

import core.utilities.results.DataResult;
import core.utilities.results.SuccessDataResult;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/galleristCar")
public class GalleristCarControllerImpl implements GalleristCarController{
	
	private GalleristCarService galleristCarService;
	@Autowired
	public GalleristCarControllerImpl(GalleristCarService galleristCarService) {
		super();
		this.galleristCarService = galleristCarService;
	}
	@Override
	@PostMapping("/save")
	public DataResult<DTOGalleristCar> save(@Valid @RequestBody DTOGalleristCarIU dtoGalleristCarIU) {
		
		return new SuccessDataResult<DTOGalleristCar>
		(this.galleristCarService.save(dtoGalleristCarIU), "galleristCar saved");
	}
	
	
	
	
	
	

}
