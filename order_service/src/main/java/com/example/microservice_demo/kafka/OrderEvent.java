package com.example.microservice_demo.kafka;

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
