package com.API.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.API.backend.entities.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository <Transaction, Long>{
}
