package com.example.microservice_demo.service;

import com.example.microservice_demo.model.Product;

import java.util.List;

public interface IProductService {
    public List<Product> getAll();
}
