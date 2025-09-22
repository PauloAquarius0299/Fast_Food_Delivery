package com.paulotech.food_fast.service;

import com.paulotech.food_fast.model.IngredientCategory;
import com.paulotech.food_fast.model.IngredientsItem;

import java.util.List;

public interface IngredientsService {
    IngredientCategory createIngredientCategory(String name, Long restaurantId) throws Exception;
    IngredientCategory findIngredientCategoryById(Long id) throws Exception;
    List<IngredientCategory> findIngredientCategoryByRestaurant(Long id) throws Exception;
    IngredientsItem createIngredientItem(Long restaurantId, String ingredientName, Long categoryId) throws Exception;
    List<IngredientsItem> findRestaurantIngredients(Long restaurantId);
    IngredientsItem updateStock(Long id) throws Exception;
}
