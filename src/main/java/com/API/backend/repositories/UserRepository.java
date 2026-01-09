package com.API.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.API.backend.entities.User;

@Repository
public interface UserRepository extends JpaRepository <User, Long> {
    
}
