package com.example.microservice_demo.Service;

import com.example.microservice_demo.Model.User;
import com.example.microservice_demo.Repository.UserRepo;

import java.util.List;

public interface IUserService {
    public List<User> getAll();
}
