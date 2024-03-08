package com.wissen.test2.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wissen.test2.models.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer>{
    public Account findByAccountNumber(int accountNumber);
    public List<Account> findByBalanceLessThan(long balance);
    public List<Account> findByBalanceGreaterThan(long balance);
}
