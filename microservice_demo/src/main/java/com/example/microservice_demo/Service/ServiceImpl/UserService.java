package com.example.microservice_demo.Service.ServiceImpl;

import com.example.microservice_demo.Model.User;
import com.example.microservice_demo.Repository.UserRepo;
import com.example.microservice_demo.Service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepo userRepo;
    @Override
    public List<User> getAll() {
        return userRepo.findAll();
    }
}
