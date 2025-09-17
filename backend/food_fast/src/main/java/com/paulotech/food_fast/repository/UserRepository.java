package com.paulotech.food_fast.repository;

import com.paulotech.food_fast.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    public User findByEmail(String username);
}
