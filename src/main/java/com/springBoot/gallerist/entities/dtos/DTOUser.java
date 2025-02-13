package com.springBoot.gallerist.entities.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DTOUser extends DTOBase{
	
	private String username;
	private String password;

}
