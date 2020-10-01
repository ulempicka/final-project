package com.example.finalproject.controller;

import com.example.finalproject.model.Category;
import com.example.finalproject.model.Ingredient;
import com.example.finalproject.model.Recipe;
import com.example.finalproject.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
public class RecipeController {

    private RecipeService recipeService;

    @Autowired
    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping("/")
    String home(Model model){
        List<Recipe> recipes = recipeService.findTop5();
        List<Category> categories = recipeService.findCategories();
        model.addAttribute("recipes", recipes);
        model.addAttribute("categories", categories);
        return "home";
    }

    @GetMapping("/wszystkie")
    String showAllRecipes(Model model){
        List<Recipe> recipes = recipeService.findAll();
        model.addAttribute("recipes", recipes);
        return "list";
    }

    @GetMapping("/przepis")
    String getRecipe(@RequestParam Long id, Model model){
        Optional<Recipe> recipe = recipeService.findById(id);
        if (recipe.isPresent()){
            model.addAttribute("recipe", recipe.get());
            model.addAttribute("ingredients", recipe.get().getIngredients());
            return "recipe";
        }else {
            return "redirect:/";
        }
    }

    @GetMapping("/dodaj")
    String getAddForm(Model model){
        Recipe recipe = new Recipe();
        Ingredient ingredient = new Ingredient();   //lista
        String category = new String();
        model.addAttribute("recipe", recipe);
        model.addAttribute("ingredient", ingredient);
        model.addAttribute("category", category);
        model.addAttribute("mode", "add");
        return "add";
    }

    @PostMapping("/dodaj")
    String add(Recipe recipe, Ingredient ingredient, String category){
        recipeService.persistRecipe(recipe, ingredient, category);
        return "redirect:/wszystkie";
//        return "redirect:/przepis?id=" + recipe.getId();
    }

    @GetMapping("/edytuj")
    String getEditForm(Model model, @RequestParam Long id){
        Optional<Recipe> recipe = recipeService.findById(id);
        if (recipe.isPresent()){
            model.addAttribute("recipe", recipe.get());
            model.addAttribute("ingredient", recipe.get().getIngredients());
            model.addAttribute("category", recipe.get().getCategory());
            model.addAttribute("mode", "edit");
            return "add";
        }else {
            return "redirect:/";
        }
    }

//    @PostMapping("/edytuj")
//    String edit(Recipe recipe){
//        recipeService.updateRecipe(recipe);
//        return "redirect:/wszystkie";
////        return "redirect:/przepis?id=" + recipe.getId();
//    }

    @GetMapping("/polub")
    String like(@RequestParam Long id){
        recipeService.updateRating(id);
        return "redirect:/przepis?id=" + id;
    }

    @GetMapping("/usun")
    String delete(@RequestParam Long id){
        recipeService.deleteRecipe(id);
        return "redirect:/wszystkie";
    }

    @GetMapping("/kategoria")
    String getCategory(@RequestParam Long id, Model model){
        Optional<Category> category = recipeService.findCategoryById(id);
        List<Recipe> recipes = recipeService.findByCategory(id);
        if (category.isPresent()){
            model.addAttribute("category", category.get());
            model.addAttribute("recipes", recipes);
            return "category";
        }else {
            return "redirect:/";
        }
    }
}
