package com.example.microservice_demo.service;

import com.example.microservice_demo.controller.request.CreateOrderRequest;
import com.example.microservice_demo.model.Order;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IOrderService {

    public List<Order> getAll();
    public Order create(CreateOrderRequest createOrderRequest);
}
