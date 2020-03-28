package com.exam7.food_order.model;

import com.exam7.food_order.util.GenerateData;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "restaurants")
@Data
@Builder
public class Restaurant {
    @Id
    private String id;
    private String name;
    private String description;

    public static Restaurant addRestaurant(){
        GenerateData.PlaceName gp = GenerateData.randomPlace();
        return Restaurant.builder()
                .name(gp.getName())
                .description(gp.getDescription())
                .build();
    }
}
