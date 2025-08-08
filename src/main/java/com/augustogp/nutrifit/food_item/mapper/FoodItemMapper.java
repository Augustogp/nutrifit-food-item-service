package com.augustogp.nutrifit.food_item.mapper;

import com.augustogp.nutrifit.food_item.dto.FoodItemRequest;
import com.augustogp.nutrifit.food_item.dto.FoodItemResponse;
import com.augustogp.nutrifit.food_item.model.FoodItem;
import org.springframework.stereotype.Component;

@Component
public class FoodItemMapper {

    public FoodItem toEntity(FoodItemRequest foodItemRequest) {

        return FoodItem.builder()
                .name(foodItemRequest.name())
                .caloriesPerGram(foodItemRequest.caloriesPerGram())
                .carbohydratesPerGram(foodItemRequest.carbohydratesPerGram())
                .proteinsPerGram(foodItemRequest.proteinsPerGram())
                .transFatsPerGram(foodItemRequest.transFatsPerGram())
                .unsaturatedFatsPerGram(foodItemRequest.unsaturatedFatsPerGram())
                .saturatedFatsPerGram(foodItemRequest.saturatedFatsPerGram())
                .build();
    }

    public FoodItemResponse toResponse(FoodItem foodItem) {

        return new FoodItemResponse(
                foodItem.getId(),
                foodItem.getName(),
                foodItem.getCaloriesPerGram(),
                foodItem.getProteinsPerGram(),
                foodItem.getCarbohydratesPerGram(),
                foodItem.getSaturatedFatsPerGram(),
                foodItem.getUnsaturatedFatsPerGram(),
                foodItem.getTransFatsPerGram());
    }
}
