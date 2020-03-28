package com.exam7.food_order.dto;

import com.exam7.food_order.model.Restaurant;
import lombok.*;
import org.springframework.data.annotation.Id;

@Data
@Builder(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public class RestaurantDTO {
    private String id;
    private String name;
    private String description;

    public static RestaurantDTO from(Restaurant restaurant){
        return builder()
                .id(restaurant.getId())
                .name(restaurant.getName())
                .description(restaurant.getDescription())
                .build();
    }
}
