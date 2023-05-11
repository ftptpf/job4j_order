package ru.job4j.order.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import ru.job4j.order.model.Product;

public interface ProductRepository extends CrudRepository<Product, Integer> {
}
