package com.paulotech.food_fast.repository;

import com.paulotech.food_fast.model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}
