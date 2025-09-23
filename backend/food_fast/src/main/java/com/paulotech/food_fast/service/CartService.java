package com.paulotech.food_fast.service;

import com.paulotech.food_fast.model.Cart;
import com.paulotech.food_fast.model.CartItem;
import com.paulotech.food_fast.request.AddCartItemRequest;

public interface CartService {
    CartItem addItemToCart(AddCartItemRequest req, String jwt) throws Exception;
    CartItem updateCratItemQuantity(Long cartItemId, int quantity) throws Exception;
    Cart removeItemFromCart(Long cartItemId, String jwt) throws Exception;
    Long calculateCartTotals(Cart cart);
    Cart findCartById(Long id) throws Exception;
    Cart findCartByUserId(Long userId) throws Exception;
    Cart clearCart(Long userId) throws Exception;
}
