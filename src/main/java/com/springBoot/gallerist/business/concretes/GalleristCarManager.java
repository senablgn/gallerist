package com.springBoot.gallerist.business.concretes;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springBoot.gallerist.business.abstracts.GalleristCarService;
import com.springBoot.gallerist.core.exceptions.BaseException;
import com.springBoot.gallerist.core.exceptions.ErrorMesssage;
import com.springBoot.gallerist.core.exceptions.MessageType;
import com.springBoot.gallerist.dataAccess.CarRepository;
import com.springBoot.gallerist.dataAccess.GalleristCarRepository;
import com.springBoot.gallerist.dataAccess.GalleristRepository;
import com.springBoot.gallerist.entities.concretes.Car;
import com.springBoot.gallerist.entities.concretes.Gallerist;
import com.springBoot.gallerist.entities.concretes.GalleristCar;
import com.springBoot.gallerist.entities.dtos.DTOAddress;
import com.springBoot.gallerist.entities.dtos.DTOCar;
import com.springBoot.gallerist.entities.dtos.DTOGallerist;
import com.springBoot.gallerist.entities.dtos.DTOGalleristCar;
import com.springBoot.gallerist.entities.dtos.IU.DTOGalleristCarIU;

@Service
public class GalleristCarManager implements GalleristCarService {

	@Autowired
	private GalleristCarRepository galleristCarRepository;
	@Autowired
	private GalleristRepository galleristRepository;
	@Autowired
	private CarRepository carRepository;
	
	private GalleristCar createGalleristCar(DTOGalleristCarIU dtoGalleristCarIU) {
		GalleristCar galleristCar=new GalleristCar();
		Optional<Gallerist> optGallerist = galleristRepository.findById(dtoGalleristCarIU.getGalleristId());
		if(optGallerist.isEmpty()) {
			throw new BaseException(new ErrorMesssage(MessageType.NO_RECORD_EXIST, null));
		}
		Optional<Car> optCar = carRepository.findById(dtoGalleristCarIU.getCarId());
		if(optCar.isEmpty()) {
			throw new BaseException(new ErrorMesssage(MessageType.NO_RECORD_EXIST, null));
		}
		
		galleristCar.setCreateDate(new Date());
		BeanUtils.copyProperties(dtoGalleristCarIU, galleristCar);
		
		galleristCar.setCar(optCar.get());
		galleristCar.setGallerist(optGallerist.get());
		
		return galleristCar;
		
	}
	
	
	
	
	
	
	
	@Override
	public DTOGalleristCar save(DTOGalleristCarIU dtoGalleristCarIU) {
		DTOGalleristCar dtoGalleristCar=new DTOGalleristCar();
		DTOGallerist dtoGallerist=new DTOGallerist();
		DTOCar dtoCar=new DTOCar();
		DTOAddress dtoAddress=new DTOAddress();
		
		GalleristCar savedGalleristCar = this.galleristCarRepository.save(createGalleristCar(dtoGalleristCarIU));
		
		BeanUtils.copyProperties(savedGalleristCar, dtoGalleristCar);
		BeanUtils.copyProperties(savedGalleristCar.getGallerist(), dtoGallerist);
		BeanUtils.copyProperties(savedGalleristCar.getCar(), dtoCar);
		
		BeanUtils.copyProperties(savedGalleristCar.getGallerist().getAddress(), dtoAddress);
		dtoGallerist.setAddress(dtoAddress);
		
		dtoGalleristCar.setGallerist(dtoGallerist);
		dtoGalleristCar.setCar(dtoCar);
		return dtoGalleristCar;
	}
	
	
	
	
	
	
}
