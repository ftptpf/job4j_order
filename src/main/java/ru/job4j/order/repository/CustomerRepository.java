package ru.job4j.order.repository;

import org.springframework.data.repository.CrudRepository;
import ru.job4j.order.model.Customer;

import java.util.Optional;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {

    Optional<Customer> findByPhone(Integer phone);
}
