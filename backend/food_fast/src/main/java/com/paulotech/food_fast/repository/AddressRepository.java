package com.paulotech.food_fast.repository;

import com.paulotech.food_fast.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
