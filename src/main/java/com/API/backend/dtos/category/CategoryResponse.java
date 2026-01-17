package com.API.backend.dtos.category;

import com.API.backend.entities.User;
import com.API.backend.enums.EnumIncomingType;

public record CategoryResponse(Long id,User user, String name, String icon, EnumIncomingType type) {

    
}
