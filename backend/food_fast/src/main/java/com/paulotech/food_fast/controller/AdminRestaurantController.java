package com.paulotech.food_fast.controller;

import com.paulotech.food_fast.model.Restaurant;
import com.paulotech.food_fast.model.User;
import com.paulotech.food_fast.request.CreateRestaurantRequest;
import com.paulotech.food_fast.response.MessageResponse;
import com.paulotech.food_fast.service.RestaurantService;
import com.paulotech.food_fast.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin/restaurants")
@RequiredArgsConstructor
public class AdminRestaurantController {

    private final RestaurantService restaurantService;
    private final UserService userService;

    @PostMapping()
    public ResponseEntity<Restaurant> createRestaurant(@RequestBody CreateRestaurantRequest req, @RequestHeader(
            "Authorization") String jwt) throws Exception{
        User user = userService.findUserByJwtToken(jwt);

        Restaurant restaurant = restaurantService.createRestaurant(req,user);
        return new ResponseEntity<>(restaurant, HttpStatus.CREATED);

    }

    @PutMapping("/{id}")
    public ResponseEntity<Restaurant> updateRestaurant(@RequestBody CreateRestaurantRequest req, @RequestHeader(
            "Authorization") String jwt, @PathVariable Long id) throws Exception{
        User user = userService.findUserByJwtToken(jwt);

        Restaurant restaurant = restaurantService.updateRestaurant(id, req);
        return new ResponseEntity<>(restaurant, HttpStatus.CREATED);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MessageResponse> deleteRestaurant(@RequestBody CreateRestaurantRequest req, @RequestHeader(
            "Authorization") String jwt, @PathVariable Long id) throws Exception{
        User user = userService.findUserByJwtToken(jwt);

        restaurantService.deleteRestaurant(id);

        MessageResponse res=new MessageResponse();
        res.setMessage("restaurant deleted successfully");
        return new ResponseEntity<>(res, HttpStatus.CREATED);

    }

    @PutMapping("/{id}/status")
    public ResponseEntity<Restaurant> updateRestaurantStatus(@RequestHeader("Authorization") String jwt, @PathVariable Long id) throws Exception{
        User user = userService.findUserByJwtToken(jwt);

        Restaurant restaurant =  restaurantService.updateRestaurantStatus(id);

        return new ResponseEntity<>(restaurant, HttpStatus.OK);

    }

    @GetMapping("/user")
    public ResponseEntity<Restaurant> findRestaurantByUserId(
            @RequestHeader("Authorization") String jwt) throws Exception {

        User user = userService.findUserByJwtToken(jwt);

        Restaurant restaurant = restaurantService.getRestaurantByUserId(user.getId());

        return ResponseEntity.ok(restaurant);
    }

}
