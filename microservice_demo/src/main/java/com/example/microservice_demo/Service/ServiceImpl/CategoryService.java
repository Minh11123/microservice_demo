package com.example.microservice_demo.Service.ServiceImpl;

import com.example.microservice_demo.Model.Category;
import com.example.microservice_demo.Repository.CategoryRepo;
import com.example.microservice_demo.Service.ICategoryServire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements ICategoryServire {

    @Autowired
    private CategoryRepo categoryRepo;
    @Override
    public List<Category> getAll() {
        return categoryRepo.findAll();
    }
}
