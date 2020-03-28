package com.exam7.food_order.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "restaurants")
@Data
@Builder
public class Restaurant {
    @Id
    private String id;
    private String name;
    private String description;
}
