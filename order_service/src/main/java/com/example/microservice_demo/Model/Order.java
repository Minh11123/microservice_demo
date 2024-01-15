package com.example.microservice_demo.Model;


import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;
import org.aspectj.weaver.ast.Or;
import org.hibernate.annotations.Columns;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Table(name = "\"order\"")
@Entity
@Data
public class Order {


    @Id
    @Column(name = "order_id")
    @GeneratedValue(strategy=GenerationType.AUTO, generator="my_entity_seq_gen")
    @SequenceGenerator(name="my_entity_seq_gen", sequenceName="MY_ENTITY_SEQ")
    private Long id;


    @Column(name = "address")
    private String address;

    @Column(name = "price")
    private Float totalPrice;

    @Column(name = "order_status")
    private String orderStatus;

    @Column(name = "creation_date")
    private Date creationDate;

    @Column(name = "payment_status")
    private String paymentStatus;

    @Column(name = "estimated_telivery_time")
    private Date estimatedTeliveryTime;


    @Column(name = "customer_id")
    private Long customerId;

    @Column(name = "customer_phone_number")
    private String customerPhoneNumber;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "order_product",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id"))
    List<Product> products = new ArrayList<>();
}
