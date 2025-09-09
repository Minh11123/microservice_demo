package com.example.refund_service.kafka;

public class OrderEvent {
    private Long orderId;

    public OrderEvent() {
    }

    public OrderEvent(Long orderId) {
        this.orderId = orderId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }
}
