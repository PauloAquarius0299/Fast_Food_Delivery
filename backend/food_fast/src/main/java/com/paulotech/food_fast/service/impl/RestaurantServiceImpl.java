package com.paulotech.food_fast.service.impl;

import com.paulotech.food_fast.dto.RestaurantDto;
import com.paulotech.food_fast.model.Address;
import com.paulotech.food_fast.model.Restaurant;
import com.paulotech.food_fast.model.User;
import com.paulotech.food_fast.repository.AddressRepository;
import com.paulotech.food_fast.repository.RestaurantRepository;
import com.paulotech.food_fast.repository.UserRepository;
import com.paulotech.food_fast.request.CreateRestaurantRequest;
import com.paulotech.food_fast.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RestaurantServiceImpl implements RestaurantService {

    private final RestaurantRepository restaurantRepository;
    private final AddressRepository addressRepository;
    private final UserRepository userRepository;

    @Override
    public Restaurant createRestaurant(CreateRestaurantRequest request, User user) {

        Address address = addressRepository.save(request.getAddress());

        Restaurant restaurant = new Restaurant();
        restaurant.setName(request.getName());
        restaurant.setDescription(request.getDescription());
        restaurant.setCuisineType(request.getCuisineType());
        restaurant.setAddress(address);
        restaurant.setContactInformation(request.getContactInformation());
        restaurant.setOpeningHouse(request.getOpeningHours());
        restaurant.setImages(request.getImages());
        restaurant.setResgistrationDate(LocalDateTime.now());
        restaurant.setOwner(user);

        return restaurantRepository.save(restaurant);
    }

    @Override
    public Restaurant updateRestaurant(Long restaurantId, CreateRestaurantRequest updatedRestaurant) throws Exception {
        Restaurant restaurant = findRestaurantById(restaurantId);

        if(restaurant.getCuisineType()!=null){
            restaurant.setCuisineType(updatedRestaurant.getCuisineType());
        }

        if(restaurant.getDescription()!=null){
            restaurant.setDescription(updatedRestaurant.getDescription());
        }

        if(restaurant.getName()!=null){
            restaurant.setName(updatedRestaurant.getName());
        }

        return restaurantRepository.save(restaurant);
    }

    @Override
    public void deleteRestaurant(Long restaurantId) throws Exception {
        Restaurant restaurant=findRestaurantById(restaurantId);

        restaurantRepository.delete(restaurant);
    }

    @Override
    public List<Restaurant> getAllRestaurants() {
        return restaurantRepository.findAll();
    }

    @Override
    public List<Restaurant> searchRestaurant(String keyword) {
        return restaurantRepository.findBySearchQuery(keyword);
    }

    @Override
    public Restaurant findRestaurantById(Long restaurantId) throws Exception {
        Optional<Restaurant> opt=restaurantRepository.findById(restaurantId);

        if(opt.isEmpty()){
            throw new Exception("restaurant not found with id "+restaurantId);
        }
        return opt.get();
    }

    @Override
    public List<Restaurant> getRestaurantByUserId(Long userId) throws Exception {
        List<Restaurant> restaurants = restaurantRepository.findByOwnerId(userId);

        if (restaurants == null || restaurants.isEmpty()) {
            throw new Exception("No restaurants found with owner id " + userId);
        }

        return restaurants;
    }


    @Override
    public RestaurantDto addToFavorites(Long restaurantId, User userId) throws Exception {
        Restaurant restaurant = findRestaurantById(restaurantId);

        RestaurantDto dto = new RestaurantDto();
        dto.setDescription(restaurant.getDescription());
        dto.setImages(restaurant.getImages());
        dto.setTitle(restaurant.getName());
        dto.setId(restaurantId);


        boolean isFavoites = false;
        List<RestaurantDto> favorites = userId.getFavorites();
        for(RestaurantDto favorite: favorites) {
           if(favorite.getId().equals(restaurantId)){
               isFavoites = true;
               break;
           }
        }

        if(isFavoites){
            favorites.removeIf(favorite -> favorite.getId().equals(restaurantId));
        } else{
            favorites.add(dto);
        }

        userRepository.save(userId);
        return dto;
    }

    @Override
    public Restaurant updateRestaurantStatus(Long id) throws Exception {
        Restaurant restaurant = findRestaurantById(id);
        restaurant.setOpen(!restaurant.isOpen());
        return restaurantRepository.save(restaurant);
    }
}
