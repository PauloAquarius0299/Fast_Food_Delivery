package com.paulotech.food_fast.service;

import com.paulotech.food_fast.dto.RestaurantDto;
import com.paulotech.food_fast.model.Restaurant;
import com.paulotech.food_fast.model.User;
import com.paulotech.food_fast.request.CreateRestaurantRequest;

import java.util.List;

public interface RestaurantService {
    Restaurant createRestaurant(CreateRestaurantRequest request, User user);
    Restaurant updateRestaurant(Long id, CreateRestaurantRequest updatedRestaurant) throws Exception;
    void deleteRestaurant(Long restaurantId) throws Exception;
    List<Restaurant> getAllRestaurants();
    List<Restaurant> searchRestaurant(String keyword);
    Restaurant findRestaurantById(Long restaurantId) throws Exception;
    List<Restaurant> getRestaurantByUserId(Long userId) throws Exception;
    RestaurantDto addToFavorites(Long restaurantId, User userId) throws Exception;
    Restaurant updateRestaurantStatus(Long id) throws Exception;
}
