package com.example.finalproject.repository;

import com.example.finalproject.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {

    List<Recipe> findAll();

    List<Recipe> findTop5ByOrderByRatingDesc();
}
