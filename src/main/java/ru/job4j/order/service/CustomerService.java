package ru.job4j.order.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.job4j.order.model.Customer;
import ru.job4j.order.repository.CustomerRepository;

import java.util.Optional;

@Service
@AllArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    public Optional<Customer> findById(Integer id) {
        return customerRepository.findById(id);
    }

    public Optional<Customer> findByPhone(Integer phone) {
        return customerRepository.findByPhone(phone);
    }

    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }



}
