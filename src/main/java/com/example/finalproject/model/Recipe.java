package com.example.finalproject.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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
    @ManyToOne()
    private Category category;
    private int rating;
    @OneToMany(mappedBy = "recipe", cascade = CascadeType.PERSIST)
    private List<Ingredient> ingredients = new ArrayList<>();
    private String preparation;

    public Recipe(String title, String description, int time, Difficulty difficulty, String preparation) {
        this.title = title;
        this.description = description;
        this.time = time;
        this.difficulty = difficulty;
        this.preparation = preparation;
    }

    public void addIngredient(Ingredient ingredient){
        ingredients.add(ingredient);
        ingredient.setRecipe(this);
    }
}
