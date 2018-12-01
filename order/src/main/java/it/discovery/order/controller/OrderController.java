package it.discovery.order.controller;


import it.discovery.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("order")
public class OrderController {

    private final OrderService orderService;

    @PostMapping("{bookId}/{number}/{customerId}")
    public int createOrder(int bookId, int number, int customerId) {
        return orderService.createOrder(bookId, number, customerId).getId();
    }

    public void addBook(int orderId, int bookId, int number) {
        orderService.addBook(orderId, bookId, number);
    }

    @PutMapping("{id}/complete")
    public void completeOrder(int orderId) {
        orderService.complete(orderId);
    }

    @PutMapping("{id}/deliver")
    public void deliver(int orderId) {
        orderService.deliver(orderId);
    }

    @PutMapping("{orderId}/cancel")
    public void cancel(@PathVariable int orderId) {
        orderService.cancel(orderId);
    }
}
