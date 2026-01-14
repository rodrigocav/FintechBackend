package com.API.backend.dtos.transaction;

import java.time.LocalDate;

import com.API.backend.entities.User;
import com.API.backend.enums.EnumIncomingType;
import com.API.backend.enums.EnumStatus;

public record TransactionResponse(Long id, User user, String description, float amount,  EnumIncomingType type, EnumStatus status, LocalDate date) {

    
}
