package com.exam7.food_order.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "clients")
@Data
@Builder
public class Client {
    @Id
    private String id;
    private String name;
    private String mail;
}
