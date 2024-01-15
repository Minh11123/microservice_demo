package com.example.microservice_demo.Model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

@Entity
@Table(name = "\"product\"")
@Data
public class Product {
    @Id
    @Column(name = "product_id")
    @GeneratedValue(strategy=GenerationType.AUTO, generator="my_entity_seq_gen")
    @SequenceGenerator(name="my_entity_seq_gen", sequenceName="MY_ENTITY_SEQ")
    private Long id;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "price")
    private Float price;



}
