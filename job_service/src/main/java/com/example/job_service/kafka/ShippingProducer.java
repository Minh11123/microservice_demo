package com.example.job_service.kafka;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class ShippingProducer {
    private final KafkaTemplate<String, OrderEvent> kafkaTemplate;

    public ShippingProducer(KafkaTemplate<String, OrderEvent> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendOrderCompleted(OrderEvent event) {
        kafkaTemplate.send("order-completed", event);
    }

    public void sendShippingFailed(OrderEvent event) {
        kafkaTemplate.send("shipping-failed", event);
    }
}
