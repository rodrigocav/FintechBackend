package com.API.backend.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.API.backend.dtos.user.UserRequest;
import com.API.backend.dtos.user.UserResponse;
import com.API.backend.entities.User;
import com.API.backend.repositories.UserRepository;

@Service
public class UserService {
    private final UserRepository repository;

    public UserService(UserRepository repository){
        this.repository = repository;
    }
    private UserResponse toResponse(User user){
        return new UserResponse(
            user.getId(),
            user.getName(),
            user.getEmail(),
            user.getPassword()
        );
    }
    
    public UserResponse create(UserRequest request){
        User user = new User(
            request.name(),
            request.email(),
            request.password()
        );
        return toResponse(repository.save(user));
    }
    
    public List<UserResponse> list(){
        return repository.findAll()
        .stream()
        .map(
            this::toResponse
        )
        .toList();
}

}

