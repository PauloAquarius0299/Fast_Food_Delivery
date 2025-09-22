package com.paulotech.food_fast.controller;

import com.paulotech.food_fast.model.Cart;
import com.paulotech.food_fast.model.CartItem;
import com.paulotech.food_fast.request.AddCartItemRequest;
import com.paulotech.food_fast.request.UpdateCartItemRequest;
import com.paulotech.food_fast.service.CartService;
import lombok.RequiredArgsConstructor;
import org.hibernate.sql.Update;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class CartController {
    private final CartService cartService;

    @PostMapping("/cart/add")
    public ResponseEntity<CartItem> addItemCart(@RequestBody AddCartItemRequest request,
                                                @RequestHeader("Authorization") String jwt) throws Exception{
        CartItem cartItem = cartService.addItemToCart(request,jwt);
        return new ResponseEntity<>(cartItem, HttpStatus.OK);
    }

    @PutMapping("/cart-item/update")
    public ResponseEntity<CartItem> updateItemCartQnty(@RequestBody UpdateCartItemRequest request,
                                                @RequestHeader("Authorization") String jwt) throws Exception{
        CartItem cartItem = cartService.updateCratItemQuantity(request.getCartItem(), request.getQuantity());
        return new ResponseEntity<>(cartItem, HttpStatus.OK);
    }

    @DeleteMapping("/cart-item/{id}/remove")
    public ResponseEntity<Cart> removeItemCart(@PathVariable Long id,
                                               @RequestHeader("Authorization") String jwt) throws Exception{
        Cart cart = cartService.removeItemFromCart(id,jwt);
        return new ResponseEntity<>(cart, HttpStatus.OK);
    }

    @PutMapping("/cart/clear")
    public ResponseEntity<Cart> clearItemCart(@RequestHeader("Authorization") String jwt) throws Exception{
        Cart cart = cartService.clearCart(jwt);
        return new ResponseEntity<>(cart, HttpStatus.OK);
    }

    @GetMapping("/cart")
    public ResponseEntity<Cart> findItemCart(@RequestHeader("Authorization") String jwt) throws Exception{
        Cart cart = cartService.findCartByUserId(jwt);
        return new ResponseEntity<>(cart, HttpStatus.OK);
    }
}
