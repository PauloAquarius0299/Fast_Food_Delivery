package com.paulotech.food_fast.controller;

import com.paulotech.food_fast.model.Food;
import com.paulotech.food_fast.model.Restaurant;
import com.paulotech.food_fast.model.User;
import com.paulotech.food_fast.request.CreateFoodRequest;
import com.paulotech.food_fast.response.MessageResponse;
import com.paulotech.food_fast.service.FoodService;
import com.paulotech.food_fast.service.RestaurantService;
import com.paulotech.food_fast.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin/food")
@RequiredArgsConstructor
public class AdminFoodController {

    private final FoodService foodService;
    private final UserService userService;
    private final RestaurantService restaurantService;

    @PostMapping
    public ResponseEntity<Food> createFood(@RequestBody CreateFoodRequest req,
                                           @RequestHeader("Authorization") String jwt ) throws Exception{
        User user = userService.findUserByJwtToken(jwt);
        Restaurant restaurant = restaurantService.findRestaurantById(req.getRestaurantId());
        Food food = foodService.createFood(req,req.getCategory(),restaurant);

        return new ResponseEntity<>(food, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MessageResponse> deleteFood(@RequestBody Long id,
                                                      @RequestHeader("Authorization") String jwt ) throws Exception{
        User user = userService.findUserByJwtToken(jwt);
        foodService.deleteFood(id);

        MessageResponse res = new MessageResponse();
        res.setMessage("Food deleted successFully");

        return new ResponseEntity<>(res, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Food> updateFoodAvaibilityStatus(@RequestBody Long id,
                                           @RequestHeader("Authorization") String jwt ) throws Exception{
        User user = userService.findUserByJwtToken(jwt);
        Food food = foodService.updateAvalibityStatus(id);

        return new ResponseEntity<>(food, HttpStatus.CREATED);
    }
}
