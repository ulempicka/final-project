package com.example.finalproject.service;

import com.example.finalproject.model.Recipe;
import com.example.finalproject.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecipeService {

    RecipeRepository recipeRepository;

    @Autowired
    public RecipeService(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    public void persistRecipe(Recipe recipeForm){
        Recipe recipe = new Recipe();
//        recipe.setTitle(recipeForm.getTitle);
//        recipe.setTitle(recipeForm.getDescription);
//        recipe.setTitle(recipeForm.getTime);
//        recipe.setTitle(recipeForm.getDifficulty);
//        recipe.setTitle(recipeForm.getCategory);
//        recipe.setTitle(recipeForm.getRating);
        recipeRepository.save(recipe);
    }
}
