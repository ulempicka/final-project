package com.example.finalproject.controller;

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
    String home(){
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
            return "recipe";
        }else {
            return "redirect:/";
        }
    }

    @GetMapping("/dodaj")
    String getAddForm(Model model){
        Recipe recipe = new Recipe();
        model.addAttribute("recipe", recipe);
        model.addAttribute("mode", "add");
        return "add";
    }

    @PostMapping("/dodaj")
    String add(Recipe recipe){
        recipeService.persistRecipe(recipe);
        return "redirect:/wszystkie";
//        return "redirect:/przepis?id=" + recipe.getId();
    }

    @GetMapping("/edytuj")
    String getEditForm(Model model, @RequestParam Long id){
        Optional<Recipe> recipe = recipeService.findById(id);
        if (recipe.isPresent()){
            model.addAttribute("recipe", recipe.get());
            model.addAttribute("mode", "edit");
            return "add";
        }else {
            return "redirect:/";
        }
    }

//    @PostMapping("/edytuj")
//    String edit(Recipe recipe){
//        Optional<Recipe> byId = recipeService.findById(recipe.getId());
//        if(byId.isPresent()){
//            Recipe recipeFromDB = byId.get();   //wstaw nowe wartosci
//            recipeService.persistRecipe(recipe);
//            return "redirect:/przepis?id=" + recipe.getId();
//        }else {
//            return "redirect:/";
//        }
//    }

    @GetMapping("/usun")
    String delete(@RequestParam Long id){
        recipeService.deleteRecipe(id);
        return "redirect:/wszystkie";
    }
}
