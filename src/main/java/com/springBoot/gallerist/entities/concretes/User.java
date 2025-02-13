package com.springBoot.gallerist.entities.concretes;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User extends BaseEntity implements UserDetails{
	@Column(name="username")
	private String username;
	@Column(name = "password")
	private String password;
	
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return List.of();
	}

}
