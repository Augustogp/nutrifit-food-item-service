package com.augustogp.nutrifit.food_item.dto;

import java.util.UUID;

public record FoodItemResponse(
        UUID id,
        String name,
        double caloriesPerGram,
        double proteinsPerGram,
        double carbohydratesPerGram,
        double saturatedFatsPerGram,
        double unsaturatedFatsPerGram,
        double transFatsPerGram
) {
}
