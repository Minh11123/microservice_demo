package com.example.microservice_demo.Service.ServiceImpl;

import com.example.microservice_demo.Model.Product;
import com.example.microservice_demo.Repository.ProductRepo;
import com.example.microservice_demo.Service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {

    @Autowired
    private ProductRepo productRepo;
    @Override
    public List<Product> getAll() {
        return productRepo.findAll();
    }
}
