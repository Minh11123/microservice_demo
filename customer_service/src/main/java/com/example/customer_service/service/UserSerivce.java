package com.example.customer_service.service;

import com.example.customer_service.model.User;
import com.example.customer_service.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserSerivce implements IUserService {

    @Autowired
    private UserRepository userRepository;
    @Override
    public Optional<User> getInfor(Long id) {
        return userRepository.findById(id);
    }
}
