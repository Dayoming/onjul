package com.tiffy.controller;

import com.tiffy.service.RecipeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RecipeRestController {

    private final RecipeService recipeService;

    public RecipeRestController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping("/recipes/search")
    public String getRecipesByIngredients(@RequestParam String ingredients) {
        return recipeService.getRecipes(ingredients);
    }
}