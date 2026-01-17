package com.API.backend.dtos.transaction;

import java.time.LocalDate;

import com.API.backend.enums.EnumIncomingType;
import com.API.backend.enums.EnumStatus;


public record TransactionRequest(Long userId, String description, float amount, EnumIncomingType type, EnumStatus status , LocalDate date) {

    
}
