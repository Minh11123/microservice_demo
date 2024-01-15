package com.example.microservice_demo.Controller.Request;

import com.example.microservice_demo.Model.Product;
import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.util.Date;
import java.util.List;

@Data
public class CreateOrderRequest {

    private String address;
    private Long customerId;

    private List<Long> productsId;
}
