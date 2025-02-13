package com.springBoot.gallerist.entities.concretes;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "addresses")
public class Address extends BaseEntity{
	
	@Column(name = "city")
	private String city;
	@Column(name = "district")
	private String district;
	@Column(name = "neighborhood")
	private String neighborhood;
	@Column(name = "street")
	private String street;

}
