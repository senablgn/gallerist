package com.springBoot.gallerist.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springBoot.gallerist.entities.concretes.GalleristCar;

public interface GalleristCarRepository extends JpaRepository<GalleristCar, Long> {

}
