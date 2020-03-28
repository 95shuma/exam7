package com.exam7.food_order.repository;

import com.exam7.food_order.model.Restaurant;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface RestaurantRepository extends PagingAndSortingRepository<Restaurant,String> {

}
