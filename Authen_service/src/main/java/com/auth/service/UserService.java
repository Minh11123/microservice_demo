package com.auth.service;

import com.auth.entity.User;
import com.auth.repository.UserRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class UserService {
    private static final Logger logger = Logger.getLogger(UserService.class);
    private static final String EXISTING_EMAIL = "test@test.com";
    private static final String OTHER_EMAIL = "other@test.com";

    @Autowired
    private UserRepository userRepository;

    public Optional<User> findByEmail(String email) {
        // All of this code would come from the database, but for simplicity of this example
        // Let's just fake it
                Optional.ofNullable(userRepository.findByEmail(email));

        return Optional.ofNullable(userRepository.findByEmail(email));
    }
}
