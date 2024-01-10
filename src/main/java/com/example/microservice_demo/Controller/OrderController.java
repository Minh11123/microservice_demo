package com.example.microservice_demo.Controller;


import com.example.microservice_demo.Model.Order;
import com.example.microservice_demo.Service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("order")
public class OrderController {

    @Autowired
    private IOrderService orderService;


    @GetMapping("")
    public ResponseEntity<?> getAll(){
        return new ResponseEntity<>(orderService.getAll(), HttpStatus.OK);
    }
}
