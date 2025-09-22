package com.paulotech.food_fast.controller;

import com.paulotech.food_fast.model.IngredientCategory;
import com.paulotech.food_fast.model.IngredientsItem;
import com.paulotech.food_fast.request.IngredientCategoryRequest;
import com.paulotech.food_fast.request.IngredientRequest;
import com.paulotech.food_fast.service.IngredientsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/ingredients")
@RequiredArgsConstructor
public class IngredientController {

    private final IngredientsService ingredientsService;

    @PostMapping("/category")
    public ResponseEntity<IngredientCategory> createIngredientsCategory(@RequestBody IngredientCategoryRequest req) throws Exception {
        IngredientCategory item = ingredientsService.createIngredientCategory(req.getName(), req.getRestaurantId());
        return new ResponseEntity<>(item, HttpStatus.CREATED);
    }

    @PostMapping
    public ResponseEntity<IngredientsItem> createIngredientsCategory(@RequestBody IngredientRequest req) throws Exception {
        IngredientsItem item = ingredientsService.createIngredientItem(req.getRestaurantId(), req.getName(),
                req.getCategoryId());
        return new ResponseEntity<>(item, HttpStatus.CREATED);
    }

    @PutMapping("/{id}/stock")
    public ResponseEntity<IngredientsItem> updateIngredientStock(@PathVariable Long id) throws Exception {
        IngredientsItem item = ingredientsService.updateStock(id);
        return new ResponseEntity<>(item, HttpStatus.OK);
    }

    @GetMapping("/restaurant/{id}")
    public ResponseEntity<List<IngredientsItem>> getRestauranIngredientId(@PathVariable Long id) throws Exception {
        List<IngredientsItem> item = ingredientsService.findRestaurantIngredients(id);
        return new ResponseEntity<>(item, HttpStatus.OK);
    }

    @GetMapping("/restaurant/{id}/category")
    public ResponseEntity<List<IngredientCategory>> getRestauranIngredientCategoryId(@PathVariable Long id) throws Exception {
        List<IngredientCategory> item = ingredientsService.findIngredientCategoryByRestaurant(id);
        return new ResponseEntity<>(item, HttpStatus.OK);
    }
}
