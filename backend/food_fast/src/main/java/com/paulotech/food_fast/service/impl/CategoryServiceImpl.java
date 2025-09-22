package com.paulotech.food_fast.service.impl;

import com.paulotech.food_fast.model.Category;
import com.paulotech.food_fast.model.Restaurant;
import com.paulotech.food_fast.repository.CategoryRepository;
import com.paulotech.food_fast.service.CategoryService;
import com.paulotech.food_fast.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final RestaurantService restaurantService;

    @Override
    public Category createCategory(String name, Long userId) throws Exception {
        List<Restaurant> restaurants = restaurantService.getRestaurantByUserId(userId);

        Restaurant restaurant = restaurants.get(0);

        Category category = new Category();
        category.setName(name);
        category.setRestaurant(restaurant);

        return categoryRepository.save(category);
    }


    @Override
    public List<Category> findCategoryByRestaurantId(Long id) throws Exception {
        List<Restaurant> restaurant = restaurantService.getRestaurantByUserId(id);
        return categoryRepository.findByRestaurantId(id);
    }

    @Override
    public Category findCategoryById(Long id) throws Exception {
        Optional<Category> optionalCategory=categoryRepository.findById(id);

        if(optionalCategory.isEmpty()){
            throw new Exception("category not found");
        }
        return optionalCategory.get();
    }
}
