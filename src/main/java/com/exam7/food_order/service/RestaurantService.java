package com.exam7.food_order.service;

import com.exam7.food_order.dto.RestaurantDTO;
import com.exam7.food_order.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import springfox.documentation.annotations.ApiIgnore;

@Service
public class RestaurantService {

    @Autowired
    RestaurantRepository rr;

    public Iterable<RestaurantDTO> findAllRestaurant(@ApiIgnore Pageable pageable){
        return rr.findAll(pageable).map(RestaurantDTO::from);
    }

}
