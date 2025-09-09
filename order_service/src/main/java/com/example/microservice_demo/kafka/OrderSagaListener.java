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

    @KafkaListener(topics = "payment-refunded", groupId = "order-service")
    public void handlePaymentRefunded(OrderEvent event) {
        orderRepo.findById(event.getOrderId()).ifPresent(order -> {
            order.setOrderStatus("payment_refunded");
            orderRepo.save(order);
        });
    }

    @KafkaListener(topics = "inventory-restored", groupId = "order-service")
    public void handleInventoryRestored(OrderEvent event) {
        orderRepo.findById(event.getOrderId()).ifPresent(order -> {
            order.setOrderStatus("inventory_restored");
            orderRepo.save(order);
        });
    }

    @KafkaListener(topics = "shipping-returned", groupId = "order-service")
    public void handleShippingReturned(OrderEvent event) {
        orderRepo.findById(event.getOrderId()).ifPresent(order -> {
            order.setOrderStatus("shipping_returned");
            orderRepo.save(order);
        });
    }
}
