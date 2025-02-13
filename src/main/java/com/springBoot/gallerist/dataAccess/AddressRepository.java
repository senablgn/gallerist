package com.springBoot.gallerist.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springBoot.gallerist.entities.concretes.Address;

public interface AddressRepository extends JpaRepository<Address, Long>{

}
