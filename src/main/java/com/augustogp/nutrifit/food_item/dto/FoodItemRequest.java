package com.augustogp.nutrifit.food_item.dto;


public record FoodItemRequest(
        String name,
        double proteinsPerGram,
        double carbohydratesPerGram,
        double saturatedFatsPerGram,
        double unsaturatedFatsPerGram,
        double transFatsPerGram
) { }
