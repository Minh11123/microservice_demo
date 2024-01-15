package com.example.microservice_demo.Service;

import com.example.microservice_demo.Controller.Request.CreateOrderRequest;
import com.example.microservice_demo.Model.Order;
import com.example.microservice_demo.Model.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IOrderService {

    public List<Order> getAll();
    public Order create(CreateOrderRequest createOrderRequest);
}
