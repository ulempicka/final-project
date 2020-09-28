package com.example.finalproject.service;

import com.example.finalproject.model.Recipe;
import com.example.finalproject.repository.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RecipeService {

    private RecipeRepository recipeRepository;
    private List<Recipe> recipes = new ArrayList<>();   //ta lista powinna byc po stronie category

    @Autowired
    public RecipeService(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    public void persistRecipe(Recipe recipeForm){
        Recipe recipe = new Recipe(recipeForm.getTitle(),recipeForm.getDescription(), recipeForm.getTime(), recipeForm.getDifficulty(), recipeForm.getCategory());
        recipes.add(recipe);    //dodaj metode pomocnicza
        recipeRepository.save(recipe);
    }

    public List<Recipe> findAll(){
        return recipeRepository.findAllByOrderByTitle();
    }

    public Optional<Recipe> findById(Long id){
        return recipeRepository.findById(id);
    }
}
