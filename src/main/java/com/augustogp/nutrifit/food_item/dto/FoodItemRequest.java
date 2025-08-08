package com.augustogp.nutrifit.food_item.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record FoodItemRequest(

        @NotBlank(message = "Name cannot be blank")
        String name,
        @NotNull(message = "Calories per gram cannot be null")
        Double caloriesPerGram,
        @NotNull(message = "Proteins per gram cannot be null")
        Double proteinsPerGram,
        @NotNull(message = "Carbohydrates per gram cannot be null")
        Double carbohydratesPerGram,
        @NotNull(message = "Saturated fats per gram cannot be null")
        Double saturatedFatsPerGram,
        @NotNull(message = "Unsaturated fats per gram cannot be null")
        Double unsaturatedFatsPerGram,
        @NotNull(message = "Trans fats per gram cannot be null")
        Double transFatsPerGram
) { }
