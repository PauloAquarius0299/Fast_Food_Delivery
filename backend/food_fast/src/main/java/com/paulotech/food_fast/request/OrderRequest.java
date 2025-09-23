package com.paulotech.food_fast.request;

import com.paulotech.food_fast.model.Address;
import lombok.Data;

@Data
public class OrderRequest {
    private Long restaurantId;
    private Address address;
}
