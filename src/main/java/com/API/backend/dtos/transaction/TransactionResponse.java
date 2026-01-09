package com.API.backend.dtos.transaction;

import java.sql.Date;

import com.API.backend.entities.User;
import com.API.backend.enums.EnumStatus;

import jakarta.persistence.EnumType;

public record TransactionResponse(Long id,String description, User user, float amount, Date date, EnumType type, EnumStatus status) {

    
}
