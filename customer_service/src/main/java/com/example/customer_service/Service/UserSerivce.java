package com.example.customer_service.Service;

import com.example.customer_service.Model.User;
import com.example.customer_service.Repository.UserRepository;
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
