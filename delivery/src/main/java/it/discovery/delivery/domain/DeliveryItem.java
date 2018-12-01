package it.discovery.delivery.domain;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class DeliveryItem {
    private int id;

    private int orderId;

    private LocalDateTime deliveryDate;

    private String address;

    private DeliveryStatus status;
}
