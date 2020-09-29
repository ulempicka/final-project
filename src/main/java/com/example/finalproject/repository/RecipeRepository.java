package com.example.finalproject.repository;

import com.example.finalproject.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {

    List<Recipe> findAllByOrderByTitle();

    List<Recipe> findTop5ByOrderByRatingDesc();

//    @Query("UPDATE Recipe r" +
//            "SET r.title = :recipeForm.title, r.title = :recipeForm.title" +
//            "WHERE r.id = recipeForm.id")
//    @Transactional
//    @Modifying
//    void updateAllFields(Recipe recipeForm);

//    @Query("UPDATE Recipe r" +
//            "SET r.rating = :likes" +
//            "WHERE r.id = id")
//    @Transactional
//    @Modifying
//    void updateRating(@Param("likes") int likes, @Param("id") Integer id);
}
