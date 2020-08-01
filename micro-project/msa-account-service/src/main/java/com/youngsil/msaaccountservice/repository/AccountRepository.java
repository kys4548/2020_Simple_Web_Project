package com.youngsil.msaaccountservice.repository;

import com.youngsil.msaaccountservice.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
}
