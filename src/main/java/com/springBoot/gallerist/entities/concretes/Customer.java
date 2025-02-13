package com.springBoot.gallerist.entities.concretes;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.springBoot.gallerist.entities.enums.CurrencyType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "customers")
public class Customer extends BaseEntity{
	
	@Column(name = "first_name")
	private String firstName;
	@Column(name = "last_name")
	private String lastName;
	@Column(name = "tckn")
	private String tckn;
	@Column(name = "date_of_birth")
	@DateTimeFormat(iso = ISO.DATE_TIME)
	private Date dateOfBirth;
	
	@OneToOne
	private Address address;
	@OneToOne
	private Account account;
	
	
	
	
	
	

}
