package com.wissen.test2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wissen.test2.models.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer>{
    
}
