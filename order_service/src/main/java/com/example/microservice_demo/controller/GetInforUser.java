package com.example.microservice_demo.controller;

import com.example.microservice_demo.controller.reponse.UserResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "customer-service")
@Component

public interface GetInforUser {

    @GetMapping("/customer/{id}")
    public ResponseEntity<UserResponse> getInfor(@PathVariable Long id);

}
