package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Integer> {

}
