package com.springBoot.gallerist.business.concretes;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springBoot.gallerist.business.abstracts.CurrencyRatesService;
import com.springBoot.gallerist.business.abstracts.SaledCarService;
import com.springBoot.gallerist.core.exceptions.BaseException;
import com.springBoot.gallerist.core.exceptions.ErrorMesssage;
import com.springBoot.gallerist.core.exceptions.MessageType;
import com.springBoot.gallerist.dataAccess.CarRepository;
import com.springBoot.gallerist.dataAccess.CustomerRepository;
import com.springBoot.gallerist.dataAccess.GalleristRepository;
import com.springBoot.gallerist.dataAccess.SaledCarRepository;
import com.springBoot.gallerist.entities.concretes.Car;
import com.springBoot.gallerist.entities.concretes.Customer;
import com.springBoot.gallerist.entities.concretes.SaledCar;
import com.springBoot.gallerist.entities.dtos.DTOAccount;
import com.springBoot.gallerist.entities.dtos.DTOAddress;
import com.springBoot.gallerist.entities.dtos.DTOCar;
import com.springBoot.gallerist.entities.dtos.DTOCustomer;
import com.springBoot.gallerist.entities.dtos.DTOGallerist;
import com.springBoot.gallerist.entities.dtos.DTOSaledCar;
import com.springBoot.gallerist.entities.dtos.IU.DTOSaledCarIU;
import com.springBoot.gallerist.entities.enums.CarStatusType;
import com.springBoot.gallerist.entities.evds.CurrencyRatesResponse;
import com.springBoot.gallerist.utils.DateUtils;

@Service
public class SaledCarManager implements SaledCarService{
	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private CarRepository carRepository;
	@Autowired
	private CurrencyRatesService currencyRatesService;
	@Autowired
	private GalleristRepository galleristRepository;
	@Autowired
	private SaledCarRepository saledCarRepository;
	
	
	public BigDecimal convertCustomerAmountToUSD(Customer customer) {
		
		CurrencyRatesResponse currencyRatesResponse = currencyRatesService.getCurrencyRates
		(DateUtils.getCurrencyDate(new Date()), DateUtils.getCurrencyDate(new Date()));
		BigDecimal usd=new BigDecimal(currencyRatesResponse.getItems().get(0).getUsd());
		BigDecimal customerUSDAmount = customer.getAccount().getAmount().divide(usd, 2, RoundingMode.HALF_UP);
		return customerUSDAmount;
	}
	
	
	
	
	
	
	
	public boolean checkAmont(DTOSaledCarIU dtoSaledCarIU) {
		Optional<Car> optCar = carRepository.findById(dtoSaledCarIU.getCarId());
		if(optCar.isEmpty()) {
			throw new BaseException(new ErrorMesssage(MessageType.NO_RECORD_EXIST, dtoSaledCarIU.getCarId().toString()));
		}
		Optional<Customer> optCustomer = customerRepository.findById(dtoSaledCarIU.getCustomerId());
		if(optCustomer.isEmpty()) {
			throw new BaseException(new ErrorMesssage(MessageType.NO_RECORD_EXIST, dtoSaledCarIU.getCarId().toString()));
		}
		
		//müşterinin parası dolar mı?
		BigDecimal customerUSDAmount = convertCustomerAmountToUSD(optCustomer.get());
		
		//compare to eşitse0/büyükse 1/küçükse -1
		
		if(customerUSDAmount.compareTo(optCar.get().getPrice())==0
				|| customerUSDAmount.compareTo(optCar.get().getPrice())>0
				) {
			return true;
		}return false;
	
	}
	
	
	
	private SaledCar createSaledCar(DTOSaledCarIU dtoSaledCarIU) {
		SaledCar saledCar=new SaledCar();
		saledCar.setCreateDate(new Date());
		saledCar.setCustomer(customerRepository.findById(dtoSaledCarIU.getCustomerId()).orElse(null));
		saledCar.setCar(carRepository.findById(dtoSaledCarIU.getCarId()).orElse(null));
		saledCar.setGallerist(galleristRepository.findById(dtoSaledCarIU.getGalleristId()).orElse(null));
		
		return saledCar;
		
	}
	
	//orelse Optional<Gallerist> içindeki Gallerist nesnesini döndürür.
	
	
	
	public boolean checkCarStatus(Long carId) {
		Optional<Car> optCar = carRepository.findById(carId);
		if(optCar.isPresent()&&optCar.get().getCarStatusType().name().equals(CarStatusType.SALED.name())) {
			//name string olarak karşılaştırır
			return false;
		}
		return true;
	}
	
	
	public BigDecimal remainingCustomerAmount(Customer customer,Car car) {
		BigDecimal CustomerAmountUSD = convertCustomerAmountToUSD(customer);
		BigDecimal customerRemainingAmountUsd = CustomerAmountUSD.subtract(car.getPrice());
		
		
		
		CurrencyRatesResponse currencyRatesResponse = currencyRatesService.getCurrencyRates
				(DateUtils.getCurrencyDate(new Date()), DateUtils.getCurrencyDate(new Date()));
		
		
		BigDecimal usd=new BigDecimal(currencyRatesResponse.getItems().get(0).getUsd());
		
		
		 return	customerRemainingAmountUsd.multiply(usd);
	
	}
	
	
	
	
	
	

	@Override
	public DTOSaledCar buyCar(DTOSaledCarIU dtoSaledCarIU) {
		if(!checkAmont(dtoSaledCarIU)) {
			throw new BaseException(new ErrorMesssage(MessageType.CUSTOMER_AMOUNT_NOT_ENOUGH, dtoSaledCarIU.getCarId().toString()));
		}
		
		if(!checkCarStatus(dtoSaledCarIU.getCarId())) {
			throw new BaseException
			(new ErrorMesssage(MessageType.CAR_STATUS_IS_SALED, dtoSaledCarIU.getCarId().toString()));
		}
		
		
		
		SaledCar savedCar = saledCarRepository.save(createSaledCar(dtoSaledCarIU));
		
		Car car = savedCar.getCar();
		car.setCarStatusType(CarStatusType.SALED);
		carRepository.save(car);
		
		
		Customer customer = savedCar.getCustomer();
		customer.getAccount().setAmount(remainingCustomerAmount(customer, car));
		customerRepository.save(customer);
		
		return toDTO(savedCar);
	}
	
	
	public DTOSaledCar toDTO(SaledCar saledCar) {
		DTOSaledCar dtoSaledCar=new DTOSaledCar();
		DTOGallerist dtoGallerist=new DTOGallerist();
				DTOAddress dtoAddressGallerist=new DTOAddress();
		DTOCar dtoCar=new DTOCar();
		DTOCustomer dtoCustomer=new DTOCustomer();
			DTOAccount dtoAccount=new DTOAccount();
			DTOAddress dtoAddressCustomer=new DTOAddress();
		
		BeanUtils.copyProperties(saledCar, dtoSaledCar);
		BeanUtils.copyProperties(saledCar.getCustomer(), dtoCustomer);
		BeanUtils.copyProperties(saledCar.getCar(), dtoCar);
		BeanUtils.copyProperties(saledCar.getGallerist(), dtoGallerist);
		
		
		
		
		BeanUtils.copyProperties(saledCar.getGallerist().getAddress(), dtoAddressGallerist);
		dtoGallerist.setAddress(dtoAddressGallerist);
		
		BeanUtils.copyProperties(saledCar.getCustomer().getAccount(), dtoAccount);
		dtoCustomer.setAccount(dtoAccount);
		
		
		BeanUtils.copyProperties(saledCar.getCustomer().getAddress(), dtoAddressCustomer);
		dtoCustomer.setAddress(dtoAddressCustomer);
		
		dtoSaledCar.setCar(dtoCar);
		dtoSaledCar.setCustomer(dtoCustomer);
		dtoSaledCar.setGallerist(dtoGallerist);
		return dtoSaledCar;
	}
	
	
	
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
