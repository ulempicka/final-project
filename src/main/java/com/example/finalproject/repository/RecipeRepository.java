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

    @Query(value = "select * from recipe r " +
            "join category c  on r.category_id = c.id " +
            "where c.id=:id", nativeQuery = true)
    List<Recipe> findByCategory(@Param("id") Long id);

    @Query("SELECT c FROM Category c")
    List<Category> findAllCategories();

    @Query("SELECT c FROM Category c WHERE c.categoryName = :category")
    Optional<Category> findCategoryByName(@Param("category") String categoryName);

    @Query("SELECT c FROM Category c WHERE c.id = :id")
    Optional<Category> findCategoryById(@Param("id") Long id);

//    @Query("UPDATE Recipe " +
//            "SET rating = rating " +
//            "WHERE id = :id")
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
