package com.springBoot.gallerist.entities.concretes;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "saled_car" ,
uniqueConstraints= {@UniqueConstraint(columnNames= {"gallerist_id","car_id","customer_id"},name="uq_gallerist_car_customer")})
public class SaledCar extends BaseEntity{//satış işlemi
	
	@ManyToOne
	private Gallerist gallerist;
	@ManyToOne
	private Car car;
	@ManyToOne
	private Customer customer;
}


//
//@ManyToOne private Gallerist gallerist;
//
//Bir satış işlemi bir galerici tarafından yapılır.
//Ancak bir galerici birçok satış işlemi yapabilir.
//Bu yüzden Many-to-One (Çoktan bire) bir ilişki var.
//@ManyToOne private Car car;
//
//Bir satış işlemi sadece bir arabayı kapsar.
//Ancak bir araba farklı zamanlarda farklı kişilere satılabilir.
//Bu yüzden Many-to-One bir ilişki var.
//@ManyToOne private Customer customer;
//
//Bir müşteri birçok araba satın alabilir.
//Ancak bir satış işlemi sadece bir müşteriyi kapsar.
//Bu yüzden Many-to-One bir ilişki var.  




