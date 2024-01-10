package com.example.microservice_demo.Service.ServiceImpl;

import com.example.microservice_demo.Model.Order;
import com.example.microservice_demo.Repository.OrderRepo;
import com.example.microservice_demo.Service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService implements IOrderService {

    @Autowired
    private OrderRepo orderRepo;
    @Override
    public List<Order> getAll() {
        return orderRepo.findAll();
    }
}
