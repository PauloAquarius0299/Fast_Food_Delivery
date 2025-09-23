package com.paulotech.food_fast.service;

import com.paulotech.food_fast.model.Order;
import com.paulotech.food_fast.model.User;
import com.paulotech.food_fast.request.OrderRequest;

import java.util.List;

public interface OrderService {
    Order createOrder(OrderRequest order, User user) throws Exception;
    Order updateOrder(Long orderId, String orderStatus) throws Exception;
    void calcelOrder(Long orderId) throws Exception;
    List<Order> getUserOrder(Long userId) throws Exception;
    List<Order> getRestaurantOrder(Long restaurantId, String orderStatus) throws Exception;
    Order findOrderById(Long orderId) throws Exception;

}
