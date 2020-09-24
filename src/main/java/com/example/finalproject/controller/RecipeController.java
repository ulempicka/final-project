package com.example.finalproject.controller;

import com.example.finalproject.model.Recipe;
import com.example.finalproject.repository.RecipeRepository;
import com.example.finalproject.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
        return "redirect:/";
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
//            animal1FromRepo.setSpecies(animal.getSpecies());    //ustawiamy pola obiektu z repo na takie jakie przyszly z formularza - animal z param
//            animal1FromRepo.setDescription(animal.getDescription());    //podmieniamy wszystkie wartosci
//            animal1FromRepo.setImageUrl(animal.getImageUrl());      //nie podajemy imie bo ma byc unikalne, nie bedziemy mogli otrzymac z repo, nie mamy id
//            return "redirect:/zwierzak?imie=" + animal.getName();
//        }else {
//            return "redirect:/";
//        }
//    }
}
