package com.paulotech.food_fast.controller;

import com.paulotech.food_fast.dto.RestaurantDto;
import com.paulotech.food_fast.model.Restaurant;
import com.paulotech.food_fast.model.User;
import com.paulotech.food_fast.service.RestaurantService;
import com.paulotech.food_fast.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/restaurants")
@RequiredArgsConstructor
public class RestaurentController {

    private final RestaurantService restaurantService;
    private final UserService userService;

    @GetMapping("/search")
    public ResponseEntity<List<Restaurant>> searchRestaurant(@RequestParam String keyword,
                                                             @RequestHeader("Authorization") String jwt) throws Exception{
        User user = userService.findUserByJwtToken(jwt);

        List<Restaurant> restaurant =  restaurantService.searchRestaurant(keyword);

        return new ResponseEntity<>(restaurant, HttpStatus.OK);

    }

    @GetMapping()
    public ResponseEntity<List<Restaurant>> getAllRestaurant(@RequestHeader("Authorization") String jwt, String keyword) throws Exception{
        User user = userService.findUserByJwtToken(jwt);
        List<Restaurant> restaurant =  restaurantService.searchRestaurant(keyword);

        return new ResponseEntity<>(restaurant, HttpStatus.OK);

    }

    @GetMapping("/{id}")
    public ResponseEntity<Restaurant> findRestaurantById(@RequestHeader("Authorization") String jwt,
                                                         @PathVariable Long id) throws Exception{

        User user = userService.findUserByJwtToken(jwt);

        Restaurant restaurant =  restaurantService.findRestaurantById(id);

        return new ResponseEntity<>(restaurant, HttpStatus.OK);
    }

    @PutMapping("/{id}/add-favorites")
    public ResponseEntity<RestaurantDto> addFavoritesRestaurant(@RequestHeader("Authorization") String jwt,
                                                                @PathVariable Long id) throws Exception{

        User user = userService.findUserByJwtToken(jwt);

        RestaurantDto restaurant =  restaurantService.addToFavorites(id, user);

        return new ResponseEntity<>(restaurant, HttpStatus.OK);
    }
}
