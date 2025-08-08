CREATE TABLE IF NOT EXISTS food_item (
    id BINARY(16) PRIMARY KEY,
    name VARCHAR(255) NOT NULL UNIQUE,
    calories_per_gram DECIMAL(8, 5) NOT NULL,
    proteins_per_gram DECIMAL(8, 5) NOT NULL,
    carbohydrates_per_gram DECIMAL(8, 5) NOT NULL,
    saturated_fats_per_gram DECIMAL(8, 5) NOT NULL,
    unsaturated_fats_per_gram DECIMAL(8, 5) NOT NULL,
    trans_fats_per_gram DECIMAL(8, 5) NOT NULL
    );

-- Insert mock data into food_item
INSERT INTO food_item (id, name, calories_per_gram, proteins_per_gram, carbohydrates_per_gram, saturated_fats_per_gram, unsaturated_fats_per_gram, trans_fats_per_gram)
VALUES
    (UUID_TO_BIN('e2f7d8c3-4f5a-4b6b-8c9d-0e1f2a3b4c5e'), 'Banana', 0.089, 0.001, 0.023, 0.000, 0.000, 0.000),
    (UUID_TO_BIN('f3a8e9d4-5a6b-4c8b-9d0e-1f2a3b4c5d6e'), 'Chicken Breast', 0.165, 0.031, 0.000, 0.000, 0.000, 0.000),
    (UUID_TO_BIN('a4b9c8d5-6e7f-4a9b-8c1d-2e34f5a6b7c8'), 'Broccoli', 0.034, 0.003, 0.007, 0.000, 0.000, 0.000),
    (UUID_TO_BIN('b5c6d7e8-9f0a-4b2c-8d4e-5f6a7b8c9d0e'), 'Rice', 0.130, 0.002, 0.028, 0.000, 0.000, 0.000),
    (UUID_TO_BIN('c6d7e8f9-0a1b-4c3d-8e5f-6a7b8c9d0e1f'), 'Almonds', 0.576, 0.021, 0.022, 0.003, 0.015, 0.000),
    (UUID_TO_BIN('d7e8f9a0-1b2c-4d3e-8f5a-6b7c8d9e0f1a'), 'Salmon', 0.208, 0.020, 0.000, 0.004, 0.013, 0.000),
    (UUID_TO_BIN('e8f9a0b1-2c3d-4e5f-8a6b-7c8d9e0f1a2b'), 'Egg', 0.155, 0.013, 0.001, 0.003, 0.007, 0.000),
    (UUID_TO_BIN('f9a0b1c2-3d4e-4f5a-8b6c-7d8e9f0a1b2c'), 'Oats', 0.389, 0.017, 0.066, 0.001, 0.005, 0.000),
    (UUID_TO_BIN('a0b1c2d3-4e5f-4a6b-8c7d-9e0f1a2b3c4d'), 'Spinach', 0.023, 0.003, 0.004, 0.000, 0.000, 0.000),
    (UUID_TO_BIN('b1c2d3e4-5f6a-4b7c-8d9e-0f1a2b3c4d5e'), 'Quinoa', 0.120, 0.014, 0.021, 0.001, 0.005, 0.000);
