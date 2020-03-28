package com.exam7.food_order.repository;

import com.exam7.food_order.model.Dish;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface DishRepository extends PagingAndSortingRepository<Dish,String> {
    Dish findDishById(String id);
}
