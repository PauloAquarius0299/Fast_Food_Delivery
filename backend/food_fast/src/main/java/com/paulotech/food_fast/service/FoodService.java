package com.paulotech.food_fast.service;

import com.paulotech.food_fast.model.Category;
import com.paulotech.food_fast.model.Food;
import com.paulotech.food_fast.model.Restaurant;
import com.paulotech.food_fast.request.CreateFoodRequest;

import java.util.List;

public interface FoodService {
    Food createFood(CreateFoodRequest req, Category category, Restaurant restaurant);
    void deleteFood(Long foodId) throws Exception;
    List<Food> getRestaurantFood(Long restaurantId, boolean isVegetarian, boolean isNonveg, boolean isSeasonal,
                                 String foodCategory);
    List<Food> searchFood(String keyword);
    Food findFoodById(Long foodId) throws Exception;
    Food updateAvalibityStatus(Long foodId) throws Exception;
}
