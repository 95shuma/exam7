package com.exam7.food_order.service;

import com.exam7.food_order.model.Client;
import com.exam7.food_order.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

    @Autowired
    ClientRepository cr;

    public Client getClientByName(String name){
        return cr.findClientByName(name);
    }
}
