package com.API.backend.dtos.category;

import com.API.backend.enums.EnumIncomingType;

public record CategoryRequest(Long userId, String name, String icon, EnumIncomingType type) {

}
