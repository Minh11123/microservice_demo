package com.example.refund_service.kafka;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class RefundProducer {
    private final KafkaTemplate<String, OrderEvent> kafkaTemplate;

    public RefundProducer(KafkaTemplate<String, OrderEvent> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendPaymentRefunded(OrderEvent event) {
        kafkaTemplate.send("payment-refunded", event);
    }
}
