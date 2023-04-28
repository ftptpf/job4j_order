package ru.job4j.order.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.job4j.order.repository.CustomerRepository;

@Service
@AllArgsConstructor
public class OrderService {

    private final CustomerRepository customerRepository;
}
