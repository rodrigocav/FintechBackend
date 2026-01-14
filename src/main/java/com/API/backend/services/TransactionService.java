package com.API.backend.services;

import org.springframework.stereotype.Service;

import com.API.backend.dtos.transaction.TransactionResponse;
import com.API.backend.entities.Transaction;
import com.API.backend.repositories.TransactionRepository;

@Service
public class TransactionService {

    private final TransactionRepository repository;

    public TransactionService(TransactionRepository repository) {
        this.repository = repository;
    }

    private TransactionResponse toResponse(Transaction transaction) {
        return TransactionResponse(
            transaction.getId(),
            transaction.getDescription(),
            transaction.getAmount(),
            transaction.getType(),
            transaction.getStatus(),
            transaction.getUser()
        );
    }
    
}
