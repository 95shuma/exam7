package com.exam7.food_order.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "orders")
@Data
@Builder
public class Order {
    @Id
    private String id;
    @DBRef
    private Client client;
    @DBRef
    private Dish dish;
    private LocalDateTime date;

    public static Order addOrder(){
        return Order.builder()
                .date(LocalDateTime.now())
                .build();
    }
}
