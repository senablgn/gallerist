package com.springBoot.gallerist.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springBoot.gallerist.entities.concretes.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long>{

}
