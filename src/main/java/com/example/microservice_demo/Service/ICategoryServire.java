package com.example.microservice_demo.Service;

import com.example.microservice_demo.Model.Category;
import com.example.microservice_demo.Service.ServiceImpl.CategoryService;

import java.util.List;

public interface ICategoryServire {


    public List<Category> getAll();
}
