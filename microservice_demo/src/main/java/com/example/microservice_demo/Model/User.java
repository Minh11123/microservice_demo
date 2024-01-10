package com.example.microservice_demo.Model;

import jakarta.persistence.*;
import lombok.ToString;

import java.util.List;

@Entity
@Table(name = "\"USER\"") // Đặt tên bảng trong dấu ngoặc kép
public class User {
    @Id
    @Column(name = "\"user_id\"") // Đặt tên cột trong dấu ngoặc kép
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_name")
    private String username;

    @Column(name = "full_name")
    private String fullname;

    @Column(name = "email")
    private String email;


    @Column(name = "password")
    private String password;

    @ToString.Exclude
    @OneToMany(mappedBy = "user")
    private List<Order> orders;
}

