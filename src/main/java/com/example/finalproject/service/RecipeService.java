package com.example.finalproject.service;

import com.example.finalproject.model.Category;
import com.example.finalproject.model.CategoryName;
import com.example.finalproject.model.Ingredient;
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

    public void persistRecipe(Recipe recipeForm, Ingredient ingredientForm, String categoryName){
        Category categoryFromDb = findCategoryByName(categoryName).get();

        Recipe recipe = new Recipe(recipeForm.getTitle(),recipeForm.getDescription(), recipeForm.getTime(), recipeForm.getDifficulty(), recipeForm.getPreparation());
        Ingredient ingredient = new Ingredient(ingredientForm.getName(), ingredientForm.getQuantity(), ingredientForm.getUnit(), ingredientForm.getAdditionalInfo());
        recipe.addIngredient(ingredient);
        recipe.setCategory(categoryFromDb);
        recipeRepository.save(recipe);
    }

    public void updateRecipe(Recipe recipeForm){
        Optional<Recipe> byId = findById(recipeForm.getId());
        if(byId.isPresent()) {
            Recipe recipeFromDB = byId.get();
            Long id = recipeFromDB.getId();
        }
    }

    public void updateRating(Long id){
        recipeRepository.updateRating(id);
    }

    public List<Recipe> findAll(){
        return recipeRepository.findAllByOrderByTitle();
    }

    public List<Recipe> findTop5(){
        return recipeRepository.findTop5ByOrderByRatingDesc();
    }

    public List<Recipe> findByCategory(CategoryName categoryName){
        return recipeRepository.findByCategory(categoryName);
    }

    public Optional<Recipe> findById(Long id){
        return recipeRepository.findById(id);
    }

    public void deleteRecipe(Long id){
        recipeRepository.deleteById(id);
    }

    public Optional<Category> findCategoryByName(String categoryName){
        return recipeRepository.findCategoryByName(categoryName);
    }

    public List<Category> findCategories(){
        return recipeRepository.findAllCategories();
    }
}
