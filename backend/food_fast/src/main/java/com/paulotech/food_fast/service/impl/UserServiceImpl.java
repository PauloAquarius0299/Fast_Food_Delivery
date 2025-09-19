package com.paulotech.food_fast.service.impl;

import com.paulotech.food_fast.config.JwtProvider;
import com.paulotech.food_fast.model.User;
import com.paulotech.food_fast.repository.UserRepository;
import com.paulotech.food_fast.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final JwtProvider jwtProvider;

    @Override
    public User findUserByJwtToken(String jwt) throws Exception {
        String email = jwtProvider.getEmailFromToken(jwt);
        User user = findUserByEmail(email);
        return user;
    }

    @Override
    public User findUserByEmail(String email) throws Exception {
        User user = userRepository.findByEmail(email);

        if(user==null){
            throw new Exception("User not found with email " + email);
        }
        return user;
    }
}
