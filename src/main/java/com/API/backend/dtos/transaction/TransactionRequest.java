package com.API.backend.dtos.transaction;

import java.sql.Date;

import com.API.backend.entities.User;
import com.API.backend.enums.EnumStatus;

import jakarta.persistence.EnumType;

public record TransactionRequest(User user, String description, float amount, EnumType type, EnumStatus status , Date date) {

    
}
