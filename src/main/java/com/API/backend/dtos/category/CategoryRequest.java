package com.API.backend.dtos.category;

import com.API.backend.entities.User;
import com.API.backend.enums.EnumType;

public record CategoryRequest(User user, String name, String icon, EnumType type) {

}
