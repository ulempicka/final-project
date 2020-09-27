package com.example.finalproject.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private int time;
    @Enumerated(EnumType.STRING)
    private Difficulty difficulty;
    //OneToMany
    private String category;    //list
    private int rating;
    //OneToMany
//    private List<Ingredient> ingredients;

    public Recipe(String title, String description, int time, Difficulty difficulty, String category) {
        this.title = title;
        this.description = description;
        this.time = time;
        this.difficulty = difficulty;
        this.category = category;
    }
}
