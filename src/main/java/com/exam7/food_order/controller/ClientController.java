package com.exam7.food_order.controller;

import com.exam7.food_order.annotations.ApiPageable;
import com.exam7.food_order.dto.OrderDTO;
import com.exam7.food_order.service.OrderService;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

@ApiPageable
@RestController
@RequestMapping("/client")
public class ClientController {
    OrderService os;

    public ClientController(OrderService os) {
        this.os = os;
    }

    @GetMapping("/id/{id}/orders")
    public Iterable<OrderDTO> findOrder(@ApiIgnore Pageable pageable, @PathVariable("id") String id){
        return os.findOrderByClientId(pageable,id);
    }
}
