package com.API.backend.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private Long id;

    @NotNull
    private String name;



    @Email
    @Column(unique = true)
    @NotNull
    private String email;

    @NotNull
    @Size(min = 8)
    private String password;
    
    public User(){ }
    
    public User(String name, String email, String password){
        this.name = name;
        this.email = email;
        this.password = password;
    }

    
}
