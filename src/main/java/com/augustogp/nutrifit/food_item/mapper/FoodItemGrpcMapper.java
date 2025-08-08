package com.augustogp.nutrifit.food_item.mapper;

import com.augustogp.nutrifit.food_item.dto.FoodItemResponse;
import com.nutrifit.fooditem.v1.GetFoodItemResponse;

public class FoodItemGrpcMapper {

    public static GetFoodItemResponse toGetFoodItemResponse(FoodItemResponse foodItemResponse) {
        return GetFoodItemResponse.newBuilder()
                .setId(foodItemResponse.id().toString())
                .setName(foodItemResponse.name())
                .setCaloriesPerGram(String.valueOf(foodItemResponse.caloriesPerGram()))
                .setProteinsPerGram(String.valueOf(foodItemResponse.proteinsPerGram()))
                .setCarbohydratesPerGram(String.valueOf(foodItemResponse.carbohydratesPerGram()))
                .setSaturatedFatsPerGram(String.valueOf(foodItemResponse.saturatedFatsPerGram()))
                .setUnsaturatedFatsPerGram(String.valueOf(foodItemResponse.unsaturatedFatsPerGram()))
                .setTransFatsPerGram(String.valueOf(foodItemResponse.transFatsPerGram()))
                .build();
    }
}
