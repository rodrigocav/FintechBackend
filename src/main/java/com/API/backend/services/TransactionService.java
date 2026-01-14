package com.API.backend.services;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.API.backend.dtos.transaction.TransactionRequest;
import com.API.backend.dtos.transaction.TransactionResponse;
import com.API.backend.entities.Transaction;
import com.API.backend.entities.User;
import com.API.backend.repositories.TransactionRepository;
import com.API.backend.repositories.UserRepository;

@Service
public class TransactionService {

    private final UserRepository userRepository;
    private final TransactionRepository repository;

    public TransactionService(UserRepository userRepository,TransactionRepository repository) {
        this.userRepository = userRepository;
        this.repository = repository;
    }

    private TransactionResponse toResponse(Transaction transaction) {
        return new TransactionResponse(
            transaction.getId(),
            transaction.getUser(),
            transaction.getDescription(),
            transaction.getAmount(),
            transaction.getType(),
            transaction.getStatus(),
            transaction.getDate()
        );
    }

    public TransactionResponse create(TransactionRequest request) {

        User user = userRepository.findById(request.userId()).get();

        Transaction transaction = new Transaction(
            user,
            request.description(),
            request.amount(),
            request.date(),
            request.type(),
            request.status()
        );
        return toResponse(repository.save(transaction));
    }

    public List<TransactionResponse> list() {
        return repository.findAll()
                .stream()
                .map(this::toResponse)
                .toList();
    }

    @Query(value  = "SELECT * FROM transactions t WHERE t.date BETWEEN :startDate AND :endDate", nativeQuery = true)
    public List<TransactionResponse> filterByDate(@Param("startDate") Date startDate, @Param("endDate") Date endDate) {
        return repository.findAll()
               .stream()
               .map(this::toResponse)
               .toList();
    }

    public TransactionResponse findById(Long id) {
        return toResponse(repository.findById(id).orElseThrow());
    }
    
}
