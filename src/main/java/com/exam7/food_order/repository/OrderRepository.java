package com.exam7.food_order.repository;

import com.exam7.food_order.model.Order;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface OrderRepository extends PagingAndSortingRepository<Order,String> {
}
