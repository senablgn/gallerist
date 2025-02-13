package com.springBoot.gallerist.entities.dtos.IU;

import java.util.Date;

import lombok.Data;

@Data
public class DTOCustomerIU {

	private String firstName;

	private String lastName;

	private String tckn;

	private Date dateOfBirth;

	private Long addressId;

	private Long accountId;
}
