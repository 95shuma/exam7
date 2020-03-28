package com.exam7.food_order.repository;

import com.exam7.food_order.model.Dish;
import org.springframework.data.repository.CrudRepository;

public interface DishRepository extends CrudRepository<Dish,String> {
    Dish findDishById(String id);
}
