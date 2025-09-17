package com.paulotech.food_fast.repository;

import com.paulotech.food_fast.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long> {
}
