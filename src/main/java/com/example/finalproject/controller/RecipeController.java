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
        model.addAttribute("recipe", recipe.get());
        return "recipe";
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

//    @GetMapping("/edytuj")
//    String getEditForm(Model model, @RequestParam(name = "imie") String name){
//        Optional<Animal> animal = animalRepository.findByName(name);
//        if (animal.isPresent()){
//            model.addAttribute("animal", animal.get());
//            model.addAttribute("mode", "edit");
//            return "add";
//        }else {
//            return "redirect:/";
//        }
//    }
//
//    @PostMapping("/edytuj")
//    String edit(Animal animal){
//        Optional<Animal> byName = animalRepository.findByName(animal.getName());
//        if(byName.isPresent()){
//            Animal animal1FromRepo = byName.get();
//            animal1FromRepo.setSpecies(animal.getSpecies());
//            animal1FromRepo.setDescription(animal.getDescription());
//            animal1FromRepo.setImageUrl(animal.getImageUrl());
//            return "redirect:/zwierzak?imie=" + animal.getName();
//        }else {
//            return "redirect:/";
//        }
//    }
}
