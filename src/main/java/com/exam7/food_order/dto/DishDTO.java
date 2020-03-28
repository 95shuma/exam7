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
    private String type;
    private int price;
    private String restaurantId;

    public static DishDTO from(Dish dish){
        return builder()
                .id(dish.getId())
                .name(dish.getName())
                .type(dish.getType())
                .price(dish.getPrice())
                .restaurantId(dish.getRestaurant().getId())
                .build();
    }
}
