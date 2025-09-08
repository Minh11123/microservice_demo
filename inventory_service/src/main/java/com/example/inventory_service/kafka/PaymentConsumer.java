package com.example.inventory_service.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class PaymentConsumer {
    private final InventoryProducer inventoryProducer;

    public PaymentConsumer(InventoryProducer inventoryProducer) {
        this.inventoryProducer = inventoryProducer;
    }

    @KafkaListener(topics = "payment-completed", groupId = "inventory-service")
    public void consume(OrderEvent event) {
        if (event.getOrderId() % 3 == 0) {
            inventoryProducer.sendInventoryRollback(event);
        } else {
            inventoryProducer.sendInventoryReserved(event);
        }
    }
}
