package com.springBoot.gallerist.dataAccess;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springBoot.gallerist.entities.concretes.User;

public interface UserRepository extends JpaRepository<User, Long>{

	Optional<User>findByUsername(String username);
}
