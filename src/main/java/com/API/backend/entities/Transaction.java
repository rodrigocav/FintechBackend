package com.API.backend.entities;
import com.API.backend.enums.*;



import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "transactions")
public class Transaction {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    private Long id;
    
    private String description;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    private float amount;
    private Date date;
    private EnumType type;
    private EnumStatus status;

    public Transaction(){ }
    
    public Transaction(String description, User user, float amount, Date date, EnumType type, EnumStatus status){
        this.description = description;
        this.user = user;
        this.amount = amount;
        this.date = date;
        this.type = type;
        this.status = status;

    }



}