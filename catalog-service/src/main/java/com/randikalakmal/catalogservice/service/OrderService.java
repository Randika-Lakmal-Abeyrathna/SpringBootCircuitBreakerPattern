package com.randikalakmal.catalogservice.service;

import com.randikalakmal.catalogservice.entity.Order;
import com.randikalakmal.catalogservice.repository.OrderRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;


    @PostConstruct
    public void initOrderTable(){

        orderRepository.saveAll(Stream.of(
                new Order("mobile", "electronics", "white", 20000),
                new Order("T-Shirt", "clothes", "black", 999),
                new Order("Jeans", "clothes", "blue", 1999),
                new Order("Laptop", "electronics", "gray", 50000),
                new Order("digital watch", "electronics", "black", 2500),
                new Order("Fan", "electronics", "black", 50000)
        ).collect(Collectors.toList()));
    }


    public List<Order> getOrders(){
        return orderRepository.findAll();
    }

    public List<Order> getOrdersByCategory(String category){
        return orderRepository.findByCategory(category);
    }


}
