package com.exam7.food_order.controller;

import com.exam7.food_order.annotations.ApiPageable;
import com.exam7.food_order.dto.DishDTO;
import com.exam7.food_order.dto.RestaurantDTO;
import com.exam7.food_order.service.RestaurantService;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

@ApiPageable
@RestController
@RequestMapping("/restaurant")
public class RestaurantController {

    RestaurantService rs;

    public RestaurantController(RestaurantService rs) {
        this.rs = rs;
    }

    @GetMapping("/all")
    public Iterable<RestaurantDTO> findAll(@ApiIgnore Pageable pageable){
        return rs.findAllRestaurant(pageable);
    }

    @GetMapping("/name/{name}/dishes")
    public Iterable<DishDTO> findDishesByRestaurantName(@ApiIgnore Pageable pageable, @PathVariable("name") String name){
        return rs.findDishesByRN(pageable,name);
    }
}
