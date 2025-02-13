package com.springBoot.gallerist.entities.dtos;

import java.util.Date;

import com.springBoot.gallerist.entities.concretes.Account;
import com.springBoot.gallerist.entities.concretes.Address;

import lombok.Data;

@Data
public class DTOCustomer extends DTOBase {

	private String firstName;

	private String lastName;

	private String tckn;

	private Date dateOfBirth;

	private DTOAddress address;

	private DTOAccount account;

}
