package com.exam7.food_order.dto;

import com.exam7.food_order.model.Dish;
import com.exam7.food_order.model.Restaurant;
import lombok.*;

import java.util.List;

@Data
@Builder(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public class DishDTO {
    private String id;
    private String name;
    private List<Dish>dishes;

    public static DishDTO from(Restaurant restaurant){
        return builder()
                .id(restaurant.getId())
                .name(restaurant.getName())
                .dishes(restaurant.getDishes())
                .build();
    }
}
