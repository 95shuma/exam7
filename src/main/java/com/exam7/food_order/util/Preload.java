package com.exam7.food_order.util;

import com.exam7.food_order.model.Client;
import com.exam7.food_order.model.Dish;
import com.exam7.food_order.model.Order;
import com.exam7.food_order.model.Restaurant;
import com.exam7.food_order.repository.ClientRepository;
import com.exam7.food_order.repository.DishRepository;
import com.exam7.food_order.repository.OrderRepository;
import com.exam7.food_order.repository.RestaurantRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Configuration
public class Preload {
    Random r = new Random();
    @Bean
    CommandLineRunner initDatabase(ClientRepository cr, DishRepository dr,
                                   OrderRepository or, RestaurantRepository rr) {
        return (args) -> {
            cr.deleteAll();
            dr.deleteAll();
            or.deleteAll();
            rr.deleteAll();

            List<Client>clients = Stream.generate(Client::addClient)
                    .limit(20)
                    .collect(Collectors.toList());
            cr.saveAll(clients);

            List<Restaurant>restaurants = Stream.generate(Restaurant::addRestaurant)
                    .limit(10)
                    .collect(Collectors.toList());
            rr.saveAll(restaurants);

            List<Dish>dishes = Stream.generate(Dish::addDish)
                    .limit(30)
                    .collect(Collectors.toList());

            for (Dish dish:dishes)
                dish.setRestaurant(restaurants.get(r.nextInt(10)));

            dr.saveAll(dishes);

            List<Order>orders = Stream.generate(Order::addOrder)
                    .limit(50)
                    .collect(Collectors.toList());
            for (Order order:orders) {
                order.setClient(clients.get(r.nextInt(20)));
                order.setDish(dishes.get(r.nextInt(30)));
            }

            System.out.println("done");
        };
    }

}