package com.API.backend.services;




import java.util.List;

import org.springframework.stereotype.Service;

import com.API.backend.dtos.category.CategoryRequest;
import com.API.backend.dtos.category.CategoryResponse;
import com.API.backend.entities.Category;
import com.API.backend.entities.User;
import com.API.backend.repositories.CategoryRepository;
import com.API.backend.repositories.UserRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class CategoryService {
    private final UserRepository userRepository;
    private final CategoryRepository repository;

    public CategoryService(UserRepository userRepository, CategoryRepository repository){
        this.userRepository = userRepository;
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

    public CategoryResponse create(CategoryRequest request) {

        User user = userRepository.findById(request.userId()).orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado!"));

        Category category = new Category(
            user,
            request.name(),
            request.icon(),
            request.type()
        );

        return toResponse(repository.save(category));
    }

    public List<CategoryResponse> listByUser(Long userId) {
        return null;
    }
}
