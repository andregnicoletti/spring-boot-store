package com.nicoletti.store.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "categoria_tb")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

}
