package com.paulotech.food_fast.service;

import com.paulotech.food_fast.model.User;

public interface UserService {

     User findUserByJwtToken(String jwt) throws Exception;

     User findUserByEmail(String email) throws Exception;
}
