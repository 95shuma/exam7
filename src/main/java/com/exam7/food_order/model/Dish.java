package com.exam7.food_order.model;

import com.exam7.food_order.util.GenerateData;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Random;

@Document(collection = "dishes")
@Data
@Builder
public class Dish {
    @Id
    private String id;
    private String name;
    private String type;
    private int price;
    @DBRef
    private Restaurant restaurant;

    public static Dish addDish(){
        Random r = new Random();
        GenerateData.DishName gd = GenerateData.randomDish();

        return Dish.builder()
                .name(gd.getName())
                .type(gd.getType())
                .price(20+r.nextInt(100))
                .build();
    }
}
