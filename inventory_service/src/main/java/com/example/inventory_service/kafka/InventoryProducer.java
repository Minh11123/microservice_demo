package com.example.inventory_service.kafka;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class InventoryProducer {
    private final KafkaTemplate<String, OrderEvent> kafkaTemplate;

    public InventoryProducer(KafkaTemplate<String, OrderEvent> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendInventoryReserved(OrderEvent event) {
        kafkaTemplate.send("inventory-reserved", event);
    }

    public void sendInventoryRollback(OrderEvent event) {
        kafkaTemplate.send("inventory-rollback", event);
    }
}
