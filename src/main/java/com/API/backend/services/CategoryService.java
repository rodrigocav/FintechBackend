package com.API.backend.services;




import org.springframework.stereotype.Service;

import com.API.backend.dtos.category.CategoryResponse;
import com.API.backend.entities.Category;
import com.API.backend.repositories.CategoryRepository;

@Service
public class CategoryService {
    private final CategoryRepository repository;

    public CategoryService(CategoryRepository repository){
        this.repository = repository;
    }
    private CategoryResponse toResponse(Category category){
        return new CategoryResponse(
            category.getId(), 
            category.getUser(),
            category.getName(),
            category.getIcon(),
            category.getType()
         );
    }
}
