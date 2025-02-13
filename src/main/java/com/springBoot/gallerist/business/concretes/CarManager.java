package com.springBoot.gallerist.business.concretes;

import java.util.Date;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springBoot.gallerist.business.abstracts.CarService;
import com.springBoot.gallerist.dataAccess.CarRepository;
import com.springBoot.gallerist.entities.concretes.Car;
import com.springBoot.gallerist.entities.dtos.DTOCar;
import com.springBoot.gallerist.entities.dtos.IU.DTOCarIU;
import com.springBoot.gallerist.entities.dtos.IU.DTOCustomerIU;

@Service
public class CarManager implements CarService{
	
	private CarRepository carRepository;
	@Autowired
	public CarManager(CarRepository carRepository) {
		super();
		this.carRepository = carRepository;
	}
	
	
	private Car createCar(DTOCarIU dtoCarIU) {
		Car car=new Car();
		car.setCreateDate(new Date());
		BeanUtils.copyProperties(dtoCarIU, car);
		return car;
	}
	
	
	
	
	
	
	@Override
	public DTOCar save(DTOCarIU dtoCarIU) {
		DTOCar dtoCar=new DTOCar();
		 Car save = this.carRepository.save(createCar(dtoCarIU));
		 BeanUtils.copyProperties(save, dtoCar);
		 return dtoCar;
		
	}
	
	
	
	
	

}
