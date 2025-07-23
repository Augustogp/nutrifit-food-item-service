package com.augustogp.nutrifit.food_item.service;

import com.augustogp.nutrifit.food_item.dto.FoodItemRequest;
import com.augustogp.nutrifit.food_item.dto.FoodItemResponse;
import com.augustogp.nutrifit.food_item.exception.ResourceNotFoundException;
import com.augustogp.nutrifit.food_item.mapper.FoodItemMapper;
import com.augustogp.nutrifit.food_item.model.FoodItem;
import com.augustogp.nutrifit.food_item.repository.FoodItemRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class FoodItemService {

    private final FoodItemRepository foodItemRepository;

    private final FoodItemMapper foodItemMapper;

    public List<FoodItemResponse> findAll() {

        return foodItemRepository.findAll()
                .stream()
                .map(foodItemMapper::toResponse)
                .toList();
    }

    public FoodItemResponse createFoodItem(FoodItemRequest foodItemRequest) {

        FoodItem foodItem = foodItemMapper.toEntity(foodItemRequest);

        foodItemRepository.save(foodItem);

        log.info("Food Item created successfully");

        return foodItemMapper.toResponse(foodItem);
    }

    public FoodItemResponse updateFoodItem(UUID id, FoodItemRequest foodItemRequest) {

        FoodItem foodItem = foodItemRepository.findById(id).orElseThrow(() ->
            new ResourceNotFoundException("Food Item with ID: " + id + " was not found.")
        );

       foodItem.setName(foodItemRequest.name());
       foodItem.setCarbohydratesPerGram(foodItemRequest.carbohydratesPerGram());
       foodItem.setProteinsPerGram(foodItemRequest.proteinsPerGram());
       foodItem.setTransFatsPerGram(foodItemRequest.transFatsPerGram());
       foodItem.setSaturatedFatsPerGram(foodItemRequest.saturatedFatsPerGram());
       foodItem.setUnsaturatedFatsPerGram(foodItemRequest.unsaturatedFatsPerGram());

       foodItemRepository.save(foodItem);

       log.info("Food Item with ID: {} updated successfully", id);

       return foodItemMapper.toResponse(foodItem);
    }

    public FoodItemResponse findByName(String name) {

        FoodItem foodItem = foodItemRepository.findByName(name)
                .orElseThrow(() -> new ResourceNotFoundException("Food Item with name: " + name + " was not found."));

        log.info("Food Item with name: {} found successfully", name);

        return foodItemMapper.toResponse(foodItem);
    }

    public void deleteFoodItem(UUID id) {

        FoodItem foodItem = foodItemRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Food Item with ID: " + id + " was not found."));

        foodItemRepository.delete(foodItem);

        log.info("Food Item with ID: {} deleted successfully", id);
    }
}
