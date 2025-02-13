package com.springBoot.gallerist.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springBoot.gallerist.entities.concretes.Gallerist;

public interface GalleristRepository extends JpaRepository<Gallerist, Long>{

}
