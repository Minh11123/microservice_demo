package com.example.microservice_demo.kafka;

import com.example.microservice_demo.model.Order;
import com.example.microservice_demo.repository.OrderRepo;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class OrderSagaListener {
    private final OrderRepo orderRepo;

    public OrderSagaListener(OrderRepo orderRepo) {
        this.orderRepo = orderRepo;
    }

    @KafkaListener(topics = {"payment-failed", "inventory-rollback", "shipping-failed"}, groupId = "order-service")
    public void handleFailed(OrderEvent event) {
        orderRepo.findById(event.getOrderId()).ifPresent(order -> {
            order.setOrderStatus("cancelled");
            orderRepo.save(order);
        });
    }

    @KafkaListener(topics = "order-completed", groupId = "order-service")
    public void handleCompleted(OrderEvent event) {
        orderRepo.findById(event.getOrderId()).ifPresent(order -> {
            order.setOrderStatus("completed");
            orderRepo.save(order);
        });
    }
}
