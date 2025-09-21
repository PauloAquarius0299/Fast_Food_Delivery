package com.paulotech.food_fast.repository;

import com.paulotech.food_fast.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {

    @Query("SELECT r FROM Restaurant r " +
            "WHERE LOWER(r.name) LIKE LOWER(CONCAT('%', :query, '%')) " +
            "   OR LOWER(r.cuisineType) LIKE LOWER(CONCAT('%', :query, '%')) " +
            "   OR LOWER(r.address.city) LIKE LOWER(CONCAT('%', :query, '%'))")
    List<Restaurant> findBySearchQuery(@Param("query") String query);

    Restaurant findByOwnerId(Long userId);
}
