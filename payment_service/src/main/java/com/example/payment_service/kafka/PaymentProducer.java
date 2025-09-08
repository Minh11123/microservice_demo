package com.example.payment_service.kafka;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class PaymentProducer {
    private final KafkaTemplate<String, OrderEvent> kafkaTemplate;

    public PaymentProducer(KafkaTemplate<String, OrderEvent> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendPaymentCompleted(OrderEvent event) {
        kafkaTemplate.send("payment-completed", event);
    }

    public void sendPaymentFailed(OrderEvent event) {
        kafkaTemplate.send("payment-failed", event);
    }
}
