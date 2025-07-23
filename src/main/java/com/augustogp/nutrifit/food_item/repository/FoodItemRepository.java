package com.augustogp.nutrifit.food_item.repository;

import com.augustogp.nutrifit.food_item.model.FoodItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface FoodItemRepository extends JpaRepository<FoodItem, UUID> {

    Optional<FoodItem> findByName(String name);
}
