package com.augustogp.nutrifit.food_item.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
public class FoodItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(unique = true)
    private String name;

    private double caloriesPerGram;

    private double proteinsPerGram;

    private double carbohydratesPerGram;

    private double saturatedFatsPerGram;

    private double unsaturatedFatsPerGram;

    private double transFatsPerGram;
}
