package com.example.microservice_demo.service.serviceImpl;

import com.example.microservice_demo.model.Category;
import com.example.microservice_demo.repository.CategoryRepo;
import com.example.microservice_demo.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements ICategoryService {

    @Autowired
    private CategoryRepo categoryRepo;
    @Override
    public List<Category> getAll() {
        return categoryRepo.findAll();
    }
}
