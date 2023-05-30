package ru.job4j.order.service;

import lombok.AllArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import ru.job4j.order.dto.OrderToKitchenDto;
import ru.job4j.order.model.Order;
import ru.job4j.order.repository.OrderRepository;

import java.util.Optional;

@Service
@AllArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final KafkaTemplate<String, Object> kafkaTemplate;

    public Order save(Order order) {
        Order savedOrder = orderRepository.save(order);
        OrderToKitchenDto orderToKitchenDto = new OrderToKitchenDto(savedOrder.getId(), savedOrder.getDishId());
        kafkaTemplate.send("job4j_orders", orderToKitchenDto);
        return savedOrder;
    }

    public Optional<Order> findById(Integer id) {
        return orderRepository.findById(id);
    }
}
