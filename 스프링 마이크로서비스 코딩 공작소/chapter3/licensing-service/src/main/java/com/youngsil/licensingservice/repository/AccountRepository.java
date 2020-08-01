package com.youngsil.licensingservice.repository;

import com.youngsil.licensingservice.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
}
