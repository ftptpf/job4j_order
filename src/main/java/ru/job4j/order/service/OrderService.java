package ru.job4j.order.service;

import lombok.AllArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import ru.job4j.order.dto.OrderSendDto;
import ru.job4j.order.model.Order;
import ru.job4j.order.repository.OrderRepository;

import java.util.Optional;

@Service
@AllArgsConstructor
public class OrderService {

    private final OrderRepository repository;
    private final KafkaTemplate<String, Object> kafkaTemplate;

    public Order save(Order order) {
        Order savedOrder = repository.save(order);
        OrderSendDto orderSendDto = new OrderSendDto(savedOrder.getId(), savedOrder.getDishId());
        kafkaTemplate.send("preorder", orderSendDto);
        kafkaTemplate.send("messengers", orderSendDto);
        return savedOrder;
    }

    public Optional<Order> findById(Integer id) {
        return repository.findById(id);
    }
}
