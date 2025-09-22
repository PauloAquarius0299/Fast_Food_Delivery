package com.paulotech.food_fast.request;

import lombok.Data;

@Data
public class UpdateCartItemRequest {
    private Long cartItem;
    private int quantity;
}
