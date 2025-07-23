-- Insert mock data into food_item
INSERT INTO food_item (id, name, proteins_per_gram, carbohydrates_per_gram, saturated_fats_per_gram, unsaturated_fats_per_gram, trans_fats_per_gram)
VALUES
(UUID_TO_BIN(UUID()), 'Chicken Breast', 0.31, 0.0, 0.01, 0.03, 0.0),
(UUID_TO_BIN(UUID()), 'White Rice', 0.025, 0.28, 0.001, 0.002, 0.0),
(UUID_TO_BIN(UUID()), 'Avocado', 0.02, 0.09, 0.02, 0.07, 0.0),
(UUID_TO_BIN(UUID()), 'Whole Egg', 0.13, 0.01, 0.03, 0.05, 0.001),
(UUID_TO_BIN(UUID()), 'Olive Oil', 0.0, 0.0, 0.015, 0.1, 0.0),
(UUID_TO_BIN(UUID()), 'Almonds', 0.21, 0.22, 0.04, 0.05, 0.0),
(UUID_TO_BIN(UUID()), 'Banana', 0.01, 0.23, 0.001, 0.002, 0.0),
(UUID_TO_BIN(UUID()), 'Greek Yogurt', 0.10, 0.04, 0.03, 0.01, 0.0),
(UUID_TO_BIN(UUID()), 'Salmon', 0.20, 0.0, 0.03, 0.08, 0.0),
(UUID_TO_BIN(UUID()), 'Peanut Butter', 0.25, 0.20, 0.05, 0.08, 0.002);
