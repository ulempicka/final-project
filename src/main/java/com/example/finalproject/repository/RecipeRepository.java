package com.example.finalproject.repository;

import com.example.finalproject.model.Category;
import com.example.finalproject.model.CategoryName;
import com.example.finalproject.model.Difficulty;
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
    Optional<Category> findCategoryByName(@Param("category") CategoryName categoryName);

    @Query("SELECT c FROM Category c WHERE c.id = :id")
    Optional<Category> findCategoryById(@Param("id") Long id);


    @Query(value = "UPDATE recipe r " +
            "        JOIN ingredient i ON r.id = i.recipe_id " +
            "        JOIN category c  ON c.id = r.category_id " +
            "    SET " +
            "        r.title = :title, r.description = :description, r.time = :time, r.difficulty = :difficulty, r.rating = :rating " +
            "    WHERE r.id = :id", nativeQuery = true)
    @Transactional
    @Modifying
    void updateAllFields(@Param("id") Long id, @Param("title") String title, @Param("description") String description, @Param("time") int time,
                         @Param("difficulty") Difficulty difficulty, @Param("rating") int rating);

    @Query("UPDATE Recipe " +
            "SET rating = rating+1 " +
            "WHERE id = :id")
    @Transactional
    @Modifying
    void updateRating(@Param("id") Long id);
}
