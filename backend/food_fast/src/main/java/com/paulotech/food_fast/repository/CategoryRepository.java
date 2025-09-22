package com.paulotech.food_fast.repository;

import com.paulotech.food_fast.model.Category;
import com.paulotech.food_fast.model.IngredientCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    @Query("SELECT c FROM Category c WHERE c.restaurant.id = :id")
    List<Category> findByRestaurantId(@Param("id") Long id);


}
