package com.springBoot.gallerist.entities.concretes;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "refresh_token")
public class RefreshToken extends BaseEntity{
	@Column(name = "refresh_token")
	private String refreshToken;
	@Column(name = "expired_date")
	private Date expiredDate;
	
	@ManyToOne
	private User user;

}
