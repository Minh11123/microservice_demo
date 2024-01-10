package com.example.microservice_demo.Model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Entity
@Table(name = "\"category\"")
@Data
public class Category {
    @Id
    @Column(name = "category_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "category_name")
    private String categoryName;

    @Column(name = "title")
    private String title;


    @ToString.Exclude
    @OneToMany(mappedBy = "category")
    private List<Product> products;
}
