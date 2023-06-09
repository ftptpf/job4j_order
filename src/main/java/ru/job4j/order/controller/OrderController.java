package ru.job4j.order.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import ru.job4j.order.dto.OrderDto;
import ru.job4j.order.model.Dish;
import ru.job4j.order.model.Order;
import ru.job4j.order.service.DishService;
import ru.job4j.order.service.OrderService;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/order")
@AllArgsConstructor
public class OrderController {

    private final OrderService orderService;
    private final DishService dishService;

    @PostMapping("/create")
    public ResponseEntity<?> createOrder(@Valid @RequestBody Order order) {

        return new ResponseEntity<>(orderService.save(order), HttpStatus.CREATED);
    }

    @GetMapping("/check-status/{id}")
    public ResponseEntity<?> checkStatus(@PathVariable Integer id) {
        Order order = orderService.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Order not found")
        );
        String body = order.isStatus() ? "Order has done" : "Order in progress";
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(body);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOrderDto(@PathVariable int id) {
        OrderDto orderDto = new OrderDto();
        Order order = orderService.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Order not found"));
        orderDto.setOrder(order);
        Dish dish = dishService.findById(order.getDishId());
        orderDto.setDish(dish);
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(orderDto);
    }

}
