package com.example.microservice_demo.service.serviceImpl;

import com.example.microservice_demo.model.Product;
import com.example.microservice_demo.repository.ProductRepo;
import com.example.microservice_demo.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

@Service
public class ProductService implements IProductService {

    @Autowired
    private ProductRepo productRepo;
    @Override
    @Cacheable("products")
    public List<Product> getAll() {
        return productRepo.findAll();
    }
}
