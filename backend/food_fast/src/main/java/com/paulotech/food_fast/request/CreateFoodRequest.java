package com.paulotech.food_fast.request;

import com.paulotech.food_fast.model.Category;
import com.paulotech.food_fast.model.IngredientsItem;
import lombok.Data;

import java.util.List;

@Data
public class CreateFoodRequest {
    private String name;
    private String description;
    private Long price;
    private Category category;
    private List<String> images;
    private Long restaurantId;
    private boolean vegetarian;
    private boolean seasional;
    private List<IngredientsItem> ingredients;
}
