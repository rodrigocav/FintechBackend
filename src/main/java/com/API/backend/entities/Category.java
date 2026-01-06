package com.API.backend.entities;

import com.API.backend.enums.EnumType;

import jakarta.persistence.ManyToOne;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    private String name;
    private String icon;
    private EnumType type;


    public Category(){ }
    
    public Category(User user, String name, String icon, EnumType type){
        this.user = user;
        this.name = name;
        this.icon = icon;
        this.type = type;
    }

}



