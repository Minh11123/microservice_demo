package com.example.customer_service.service;

import com.example.customer_service.model.User;

import java.util.Optional;

public interface IUserService {

    public Optional<User> getInfor(Long id);
}
