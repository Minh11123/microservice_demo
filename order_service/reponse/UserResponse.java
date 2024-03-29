package com.example.microservice_demo.controller.reponse;

import jakarta.persistence.*;
import lombok.Data;

@Data
public class UserResponse {
    private Long id;

    private String email;

    private String fullName;

    private String phoneNumber;

    private String extraInfo;
}
