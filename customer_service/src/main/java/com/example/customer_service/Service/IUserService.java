package com.example.customer_service.Service;

import com.example.customer_service.Model.User;

import java.util.Optional;

public interface IUserService {

    public Optional<User> getInfor(Long id);
}
