package it.discovery.delivery.controller;

import it.discovery.delivery.domain.DeliveryStatus;
import it.discovery.delivery.dto.DeliveryDTO;
import it.discovery.delivery.service.DeliveryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class DeliveryController {

    private final DeliveryService deliveryService;

    @GetMapping("/{id}")
    public DeliveryStatus status(@PathVariable int id) {
        return DeliveryStatus.PENDING;
    }

    @PostMapping
    public int deliver(@RequestBody DeliveryDTO item) {
        deliveryService.deliver(item);
        return 1;//TODO
    }

}
