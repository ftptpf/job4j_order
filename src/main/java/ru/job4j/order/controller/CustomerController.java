package ru.job4j.order.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import ru.job4j.order.model.Customer;
import ru.job4j.order.model.Order;
import ru.job4j.order.service.CardService;
import ru.job4j.order.service.CustomerService;
import ru.job4j.order.service.OrderService;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/customer")
@AllArgsConstructor
public class CustomerController {

    private final CustomerService customerService;
    private final OrderService orderService;
    private final CardService cardService;

    @PostMapping("/create-order")
    public ResponseEntity<?> createOrder(@Valid @RequestBody Order order) {
        return new ResponseEntity<>(orderService.save(order), HttpStatus.CREATED);
    }

    @PutMapping("/buy-card/{cardId}")
    public ResponseEntity<?> buyCard(@RequestBody Customer customer, @PathVariable Integer cardId) {
        customerService.findById(customer.getId()).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Customer not found")
        );
        cardService.findById(cardId).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Card not found")
        );
        return null;
    }

    @GetMapping("/check-order-status/{id}")
    public ResponseEntity<?> checkOrderStatus(@PathVariable Integer id) {
        Order order = orderService.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Order not found")
        );
        String body = order.isStatus() ? "Order has done" : "Order in progress";
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(body);
    }










}
