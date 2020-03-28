package com.exam7.food_order.repository;

import com.exam7.food_order.model.Client;
import org.springframework.data.repository.CrudRepository;

public interface ClientRepository extends CrudRepository<Client,String> {
    Client findClientById(String id);
    Client findClientByName(String name);
}
