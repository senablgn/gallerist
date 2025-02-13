package com.springBoot.gallerist.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springBoot.gallerist.entities.concretes.Car;

public interface CarRepository extends JpaRepository<Car, Long>{

}
