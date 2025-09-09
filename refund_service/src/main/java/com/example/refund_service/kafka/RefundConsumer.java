package com.example.refund_service.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class RefundConsumer {
    private final RefundProducer refundProducer;

    public RefundConsumer(RefundProducer refundProducer) {
        this.refundProducer = refundProducer;
    }

    @KafkaListener(topics = "refund-requested", groupId = "refund-service")
    public void consume(OrderEvent event) {
        refundProducer.sendPaymentRefunded(event);
    }
}
