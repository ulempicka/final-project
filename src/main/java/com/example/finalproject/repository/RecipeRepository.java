package com.example.finalproject.repository;

import com.example.finalproject.model.Category;
import com.example.finalproject.model.CategoryName;
import com.example.finalproject.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {

    List<Recipe> findAllByOrderByTitle();

    List<Recipe> findTop5ByOrderByRatingDesc();

    List<Recipe> findByCategory(CategoryName categoryName);

    @Query("SELECT c FROM Category c")
    List<Category> findAllCategories();

    @Query("SELECT c FROM Category c WHERE c.categoryName = :category")
    Optional<Category> findCategoryByName(@Param("category") String categoryName);

//    @Query("UPDATE Recipe r" +
//            "SET r.title = :recipeForm.title, r.title = :recipeForm.title" +
//            "WHERE r.id = recipeForm.id")
//    @Transactional
//    @Modifying
//    void updateAllFields(Recipe recipeForm);

    @Query("UPDATE Recipe " +
            "SET rating = rating+1 " +
            "WHERE id = :id")
    @Transactional
    @Modifying
    void updateRating(@Param("id") Long id);
}
