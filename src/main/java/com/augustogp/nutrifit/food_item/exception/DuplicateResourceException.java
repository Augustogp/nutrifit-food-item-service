package com.augustogp.nutrifit.food_item.exception;

import jakarta.validation.constraints.NotBlank;

public class DuplicateResourceException extends RuntimeException {
    public DuplicateResourceException(@NotBlank(message = "Name cannot be blank") String s) {
    }
}
