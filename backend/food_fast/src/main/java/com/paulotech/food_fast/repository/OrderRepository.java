package com.paulotech.food_fast.repository;

import com.paulotech.food_fast.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByCustomerId(Long id);
    List<Order> findByRestaurantId(Long restaurantId);
}
