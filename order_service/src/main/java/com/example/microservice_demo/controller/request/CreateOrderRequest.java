package com.example.microservice_demo.controller.request;

import lombok.Data;

import java.util.List;

@Data
public class CreateOrderRequest {

    private String address;
    private Long customerId;

    private List<Long> productsId;
}
