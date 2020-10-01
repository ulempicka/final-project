package com.example.finalproject.model;

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
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private CategoryName categoryName;
    private String polishName;
    private String categoryDescription;
    private String categoryImgUrl;
    @OneToMany(mappedBy = "category", cascade = CascadeType.PERSIST)
    private List<Recipe> recipes = new ArrayList<>();

    public Category(CategoryName categoryName, String polishName, String categoryDescription, String categoryImgUrl) {
        this.categoryName = categoryName;
        this.polishName = polishName;
        this.categoryDescription = categoryDescription;
        this.categoryImgUrl = categoryImgUrl;
    }

    public void addRecipe(Recipe recipe){
        recipes.add(recipe);
        recipe.setCategory(this);
    }
}
