package com.API.backend.controllers;

import java.sql.Date;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.API.backend.dtos.transaction.TransactionRequest;
import com.API.backend.dtos.transaction.TransactionResponse;
import com.API.backend.services.TransactionService;

@RestController
@RequestMapping("api/transactions")
public class TransactionController {
    
    private final TransactionService service;

    public TransactionController(TransactionService service) {
        this.service = service;
    }

    @GetMapping
    public List<TransactionResponse> list() {
        return service.list();
    }

    @GetMapping("/betweenDates")
    public List<TransactionResponse> filterByDate(
        @RequestParam("startDate") Date startDate,
        @RequestParam("endDate") Date endDate
    ) {

        return service.filterByDate(startDate, endDate);

    }
    

    @PostMapping
    public TransactionResponse create(@RequestBody TransactionRequest request) {
        return service.create(request);
    }
}
