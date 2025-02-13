package com.springBoot.gallerist.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springBoot.gallerist.entities.concretes.SaledCar;

public interface SaledCarRepository extends JpaRepository<SaledCar, Long>{

}
