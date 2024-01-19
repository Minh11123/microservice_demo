package com.example.microservice_demo.controller;


import com.example.microservice_demo.controller.request.CreateOrderRequest;
import com.example.microservice_demo.repository.OrderRepo;
import com.example.microservice_demo.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("order")
public class OrderController {
    @Autowired
    private IOrderService orderService;

    @Autowired
    private OrderRepo orderRepo;

    @Autowired
    private GetInforUser getInforUser;


    @GetMapping("")
    public ResponseEntity<?> getAll(){
        return new ResponseEntity<>(orderService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable long id){
        return new ResponseEntity<>(orderRepo.findById(id), HttpStatus.OK);
    }

    @GetMapping("/userInfor/{id}")
    public ResponseEntity<?> getUserInfor(@PathVariable long id){
        return getInforUser.getInfor(id);
    }


    @PostMapping("")
    public ResponseEntity<?> create(@RequestBody CreateOrderRequest createOrderRequest){
        return new ResponseEntity<>(orderService.create(createOrderRequest), HttpStatus.OK);
    }
}
