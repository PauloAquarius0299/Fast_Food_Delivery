package com.paulotech.food_fast.response;

import com.paulotech.food_fast.model.USER_ROLE;
import lombok.Data;

@Data
public class AuthResponse {
    private String jwt;
    private String message;
    private USER_ROLE role;
}
