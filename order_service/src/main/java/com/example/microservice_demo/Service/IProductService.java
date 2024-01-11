package com.example.microservice_demo.Service;

import com.example.microservice_demo.Model.Order;
import com.example.microservice_demo.Model.Product;

import java.util.List;

public interface IProductService {
    public List<Product> getAll();
}
