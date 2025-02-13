package com.springBoot.gallerist.api.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springBoot.gallerist.api.abstracts.GalleristController;
import com.springBoot.gallerist.business.abstracts.GalleristService;
import com.springBoot.gallerist.entities.dtos.DTOGallerist;
import com.springBoot.gallerist.entities.dtos.IU.DTOGalleristIU;

import core.utilities.results.DataResult;
import core.utilities.results.SuccessDataResult;
import jakarta.validation.Valid;
@RestController
@RequestMapping("/api/gallerist")
public class GalleristControllerImpl implements GalleristController{
	
	private GalleristService galleristService;
	@Autowired
	public GalleristControllerImpl(GalleristService galleristService) {
		super();
		this.galleristService = galleristService;
	}
	@Override
	@PostMapping("/save")
	public DataResult<DTOGallerist> save(@Valid @RequestBody DTOGalleristIU dtoGalleristIU) {
		return new SuccessDataResult<DTOGallerist>(this.galleristService.save(dtoGalleristIU), "gallerist saved");
	}
	
	
	
	
	
	

}
