package com.API.backend.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.API.backend.entities.Category;

@Repository
public interface CategoryRepository extends JpaRepository <Category, Long> {
    
}
