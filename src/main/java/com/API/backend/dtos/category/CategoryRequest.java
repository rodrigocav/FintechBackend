package com.API.backend.dtos.category;

import com.API.backend.enums.EnumType;

public record CategoryRequest(Long userId, String name, String icon, EnumType type) {

}
