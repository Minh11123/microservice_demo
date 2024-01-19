package com.example.microservice_demo.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "\"category\"")
@Data
public class Category {
    @Id
    @Column(name = "category_id")
    @GeneratedValue(strategy=GenerationType.AUTO, generator="my_entity_seq_gen")
    @SequenceGenerator(name="my_entity_seq_gen", sequenceName="MY_ENTITY_SEQ")
    private Long id;


    @Column(name = "category_name")
    private String categoryName;

    @Column(name = "title")
    private String title;

    @OneToMany
    @JoinColumn(name = "category_id")
    private List<Product> products;


}
