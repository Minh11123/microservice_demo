package com.example.microservice_demo.Model;


import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;
import org.aspectj.weaver.ast.Or;
import org.hibernate.annotations.Columns;

import java.util.List;

@Table(name = "\"order\"")
@Entity
@Data
public class Order {


    @Id
    @Column(name = "order_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ToString.Exclude
    @OneToMany(mappedBy = "order")
    private List<Product> products;
}
