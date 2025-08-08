package com.augustogp.nutrifit.food_item.controller;

import com.augustogp.nutrifit.food_item.dto.FoodItemRequest;
import com.augustogp.nutrifit.food_item.dto.FoodItemResponse;
import com.augustogp.nutrifit.food_item.service.FoodItemService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Hashtable;
import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/food_items")
public class FoodItemController {

    private final FoodItemService foodItemService;

    @GetMapping
    public ResponseEntity<List<FoodItemResponse>> getAllFoodItems() {

        List<FoodItemResponse> foodItemList = foodItemService.findAll();
        return ResponseEntity.ok(foodItemList);
    }

    @GetMapping("/name/{name}")
    public ResponseEntity<FoodItemResponse> getFoodItemByName(@PathVariable String name) {

        FoodItemResponse foodItemResponse = foodItemService.findByName(name);

        return ResponseEntity.ok(foodItemResponse);
    }

    @PostMapping
    public ResponseEntity<FoodItemResponse> createFoodItem(@Valid @RequestBody FoodItemRequest foodItemRequest) {

        FoodItemResponse foodItemResponse = foodItemService.createFoodItem(foodItemRequest);

        return ResponseEntity.status(HttpStatus.CREATED).body(foodItemResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FoodItemResponse> updateFoodItem(@PathVariable UUID id, @Valid @RequestBody FoodItemRequest foodItemRequest) {

        FoodItemResponse foodItemResponse = foodItemService.updateFoodItem(id, foodItemRequest);

        return ResponseEntity.ok(foodItemResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFoodItem(@PathVariable UUID id) {

        foodItemService.deleteFoodItem(id);
        return ResponseEntity.noContent().build();
    }
}
