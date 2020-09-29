package com.example.finalproject.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int quantity;
    @Enumerated(EnumType.STRING)
    private IngredientUnit unit;
    private String description;

    @ManyToOne
    private Recipe recipe;
}
