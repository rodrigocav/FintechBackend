package com.API.backend.repositories;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.API.backend.entities.Category;

@Repository
public interface CategoryRepository extends JpaRepository <Category, Long> {
    
    @Query(value = "SELECT * FROM categories c WHERE c.user_id = :userId", nativeQuery = true)
    List<Category> findAllByUser(
       @Param("userId") Long userId
    );
}
