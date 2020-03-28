package com.exam7.food_order.controller;

import com.exam7.food_order.annotations.ApiPageable;
import com.exam7.food_order.dto.OrderDTO;
import com.exam7.food_order.service.OrderService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@ApiPageable
@RestController
@RequestMapping("/order")
public class OrderController {
    OrderService os;

    public OrderController(OrderService os) {
        this.os = os;
    }

    @PostMapping()
    public OrderDTO createOrder(@RequestBody OrderDTO orderDTO){
        return os.createOrder(orderDTO);
    }
}
