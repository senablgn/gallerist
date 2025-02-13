package com.springBoot.gallerist.entities.concretes;

import java.math.BigDecimal;

import com.springBoot.gallerist.entities.enums.CarStatusType;
import com.springBoot.gallerist.entities.enums.CurrencyType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cars")
public class Car extends BaseEntity{
	@Column(name = "plaka")
	private String plaka;
	@Column(name = "brand")
	private String brand;
	@Column(name = "model")
	private String model;
	@Column(name = "production_year")
	private Integer productionYear;
	@Column(name = "price" , precision = 10, scale = 3)
	private BigDecimal price;
	@Column(name = "currency_type")
	@Enumerated(EnumType.STRING)
	private CurrencyType currencyType;
	@Column(name = "damage_price")
	private BigDecimal damagePrice;
	@Column(name = "car_status_type")
	@Enumerated(EnumType.STRING)
	private CarStatusType carStatusType;
	
	
	
	
	

}
