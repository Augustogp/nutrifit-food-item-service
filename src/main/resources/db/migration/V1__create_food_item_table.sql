CREATE TABLE food_item (
    id BINARY(16) PRIMARY KEY,
    name VARCHAR(255) NOT NULL UNIQUE,
    proteins_per_gram DECIMAL(8, 5) NOT NULL,
    carbohydrates_per_gram DECIMAL(8, 5) NOT NULL,
    saturated_fats_per_gram DECIMAL(8, 5) NOT NULL,
    unsaturated_fats_per_gram DECIMAL(8, 5) NOT NULL,
    trans_fats_per_gram DECIMAL(8, 5) NOT NULL
);