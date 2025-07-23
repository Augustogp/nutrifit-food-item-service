package com.augustogp.nutrifit.food_item;

import com.augustogp.nutrifit.food_item.dto.FoodItemResponse;
import com.augustogp.nutrifit.food_item.model.FoodItem;
import io.restassured.RestAssured;
import jakarta.transaction.Transactional;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.context.annotation.Import;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.jdbc.Sql;
import org.testcontainers.containers.MySQLContainer;

import java.util.UUID;

@Import(TestcontainersConfiguration.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Transactional
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@Sql(scripts = "/testdata/insert_food_items.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_CLASS)
class FoodItemServiceApplicationTests {

	@Autowired
	MySQLContainer<?> mySQLContainer;

	@LocalServerPort
	Integer port;

	@BeforeEach
    void setup() {

		RestAssured.baseURI = "http://localhost";
		RestAssured.port = port;
	}

	@Test
	void shouldCreateFoodItem() {

		String requestBody = """
				{
					"name": "Apple",
					"proteinsPerGram": 0.003,
					"carbohydratesPerGram": 0.137,
					"saturatedFatsPerGram": 0.0003,
					"unsaturatedFatsPerGram": 0.0001,
					"transFatsPerGram": 0.0
				}
				""";

		RestAssured.given()
				.contentType("application/json")
				.body(requestBody)
			.when()
				.post("/api/food_items")
			.then()
				.statusCode(HttpStatus.CREATED.value())
				.body("id", Matchers.notNullValue())
				.body("name", Matchers.equalTo("Apple"))
				.body("proteinsPerGram", Matchers.equalTo(0.003F));
	}

	@Test
	void shouldUpdateFoodItem() {

		String foodItemName = "Avocado";

		FoodItemResponse foodItemResponse = RestAssured.given()
				.contentType("application/json")
			.when()
				.get("/api/food_items/name/{name}", foodItemName)
			.then()
				.statusCode(HttpStatus.OK.value())
				.extract()
				.as(FoodItemResponse.class);

		UUID foodItemId = foodItemResponse.id();

		String updateRequestBody = """
				{
					"name": "Updated Avocado",
					"proteinsPerGram": 0.004,
					"carbohydratesPerGram": 0.138,
					"saturatedFatsPerGram": 0.0004,
					"unsaturatedFatsPerGram": 0.0002,
					"transFatsPerGram": 0.0
				}
				""";

		RestAssured.given()
				.contentType("application/json")
				.body(updateRequestBody)
			.when()
				.put("/api/food_items/{id}", foodItemId)
			.then()
				.statusCode(HttpStatus.OK.value())
				.body("id", Matchers.equalTo(foodItemId.toString()))
				.body("name", Matchers.equalTo("Updated Avocado"))
				.body("proteinsPerGram", Matchers.equalTo(0.004F));
	}

	@Test
	void shouldDeleteFoodItem() {

		String foodItemName = "Banana";

		FoodItemResponse foodItemResponse = RestAssured.given()
				.contentType("application/json")
			.when()
				.get("/api/food_items/name/{name}", foodItemName)
			.then()
				.statusCode(HttpStatus.OK.value())
				.extract()
				.as(FoodItemResponse.class);

		UUID foodItemId = foodItemResponse.id();

		RestAssured.given()
				.contentType("application/json")
			.when()
				.delete("/api/food_items/{id}", foodItemId)
			.then()
				.statusCode(HttpStatus.NO_CONTENT.value());

//		RestAssured.given()
//				.contentType("application/json")
//			.when()
//				.get("/api/food_items/name/{name}", foodItemName)
//			.then()
//				.statusCode(HttpStatus.NOT_FOUND.value());
	}

}
