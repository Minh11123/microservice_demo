package com.example.job_service.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class ShippingConsumer {
    private final ShippingProducer shippingProducer;

    public ShippingConsumer(ShippingProducer shippingProducer) {
        this.shippingProducer = shippingProducer;
    }

    @KafkaListener(topics = "inventory-reserved", groupId = "shipping-service")
    public void consume(OrderEvent event) {
        if (event.getOrderId() % 5 == 0) {
            shippingProducer.sendShippingFailed(event);
        } else {
            shippingProducer.sendOrderCompleted(event);
        }
    }
}
