package com.exam7.food_order.service;

import com.exam7.food_order.dto.DishDTO;
import com.exam7.food_order.model.Restaurant;
import com.exam7.food_order.repository.DishRepository;
import com.exam7.food_order.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import springfox.documentation.annotations.ApiIgnore;

@Service
public class DishService {
    @Autowired
    DishRepository dr;

    @Autowired
    RestaurantRepository rr;

    public Iterable<DishDTO> findDishes(@ApiIgnore Pageable pageable, String name){
        Restaurant restaurant = rr.findRestaurantByName(name);
        return dr.findAll(pageable).map(DishDTO::from).filter(dishDTO -> restaurant.getId().equals(dishDTO.getRestaurantId()));
    }
}
