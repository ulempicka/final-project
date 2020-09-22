package com.example.finalproject.model;

import java.util.List;

public class Recipe {

    private Long id;
    private String title;
    private String description;
    private int timePrep;
    private Difficulty difficulty;
    private String category;
    private boolean like;
    private double rating;
    private List<Ingredient> ingredients;

}
