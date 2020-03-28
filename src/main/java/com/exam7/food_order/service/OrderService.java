package com.exam7.food_order.service;

import com.exam7.food_order.dto.OrderDTO;
import com.exam7.food_order.model.Client;
import com.exam7.food_order.model.Dish;
import com.exam7.food_order.model.Order;
import com.exam7.food_order.repository.ClientRepository;
import com.exam7.food_order.repository.DishRepository;
import com.exam7.food_order.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import springfox.documentation.annotations.ApiIgnore;

@Service
public class OrderService {

    @Autowired
    ClientRepository cr;

    @Autowired
    DishRepository dr;

    @Autowired
    OrderRepository or;

    public OrderDTO createOrder(OrderDTO orderDTO){
        Client client = cr.findClientById(orderDTO.getClientId());
        Dish dish = dr.findDishById(orderDTO.getDishId());
        Order order =Order.builder()
                .id(orderDTO.getId())
                .client(client)
                .dish(dish)
                .date(orderDTO.getDate())
                .build();
        or.save(order);
        return OrderDTO.from(order);
    }

    public Iterable<OrderDTO> findOrderByClientId(@ApiIgnore Pageable pageable, String id){
        return or.findAll(pageable).map(OrderDTO::from).filter(orderDTO -> id.equals(orderDTO.getClientId()));
    }
}
