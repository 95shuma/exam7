package com.exam7.food_order.dto;

import com.exam7.food_order.model.Client;
import lombok.*;

@Data
@Builder(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public class ClientDTO {
    private String id;
    private String name;
    private String mail;
    private String pass;

    public static ClientDTO from(Client client){
        return builder()
                .id(client.getId())
                .name(client.getName())
                .mail(client.getMail())
                .pass(client.getPass())
                .build();
    }
}
