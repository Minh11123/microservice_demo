package com.example.payment_service.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class PaymentConsumer {
    private final PaymentProducer paymentProducer;

    public PaymentConsumer(PaymentProducer paymentProducer) {
        this.paymentProducer = paymentProducer;
    }

    @KafkaListener(topics = "order-created", groupId = "payment-service")
    public void consume(OrderEvent event) {
        if (event.getOrderId() % 2 == 0) {
            paymentProducer.sendPaymentCompleted(event);
        } else {
            paymentProducer.sendPaymentFailed(event);
        }
    }
}
