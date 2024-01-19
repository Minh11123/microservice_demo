package com.example.customer_service.controller;

import com.example.customer_service.model.User;
import com.example.customer_service.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("customer")
public class UserController {

    @Autowired
    private IUserService iUserService;

    @GetMapping("/{id}")
    public ResponseEntity getInfor(@PathVariable Long id){
        Optional<User> user = iUserService.getInfor(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}
