package com.springBoot.gallerist.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springBoot.gallerist.entities.concretes.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {

}
