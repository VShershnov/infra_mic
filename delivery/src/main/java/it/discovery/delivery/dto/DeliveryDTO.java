package it.discovery.delivery.dto;

import lombok.Data;

@Data
public class DeliveryDTO {
    private final int orderId;

    private final String address;
}
